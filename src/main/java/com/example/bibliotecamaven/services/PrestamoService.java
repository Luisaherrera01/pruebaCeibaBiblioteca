package com.example.bibliotecamaven.services;

import com.example.bibliotecamaven.entities.Prestamo;
import com.example.bibliotecamaven.repositories.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.Optional;
@Service
public class PrestamoService implements ServicesInterface<Prestamo> {
    @Autowired //se inyecta dependencia
    protected PrestamoRepository prestamoRepositorio;

    @Override
    public Prestamo registrar(String isbn, String identificacionUsuario, Integer tipoUsuario, LocalDate fechaMaximaDevolucion) throws Exception {
        validarUsuarioPrestamo(identificacionUsuario, tipoUsuario);
        calcularFechaMaximaDevolucion(tipoUsuario);

        Prestamo prestamo = new Prestamo();
        prestamo.setIsbn(isbn);
        prestamo.setIdentificacionUsuario(identificacionUsuario);
        prestamo.setTipoUsuario(tipoUsuario);
        prestamo.setFechaMaximaDevolucion(fechaMaximaDevolucion);
        return prestamoRepositorio.save(prestamo);
    }
    private void validarUsuarioPrestamo(String identificacionUsuario, Integer tipoUsuario) throws Exception {
        if (tipoUsuario == 3) {
            boolean tienePrestamoElUsuario = prestamoRepositorio.existsByIdentificacionUsuario(identificacionUsuario);
            if (tienePrestamoElUsuario) {
                throw new Exception("El usuario con identificación " + identificacionUsuario + " ya tiene un libro prestado");
            }
        }
    }

    private void calcularFechaMaximaDevolucion(Integer tipoUsuario) throws Exception {
        DateTimeFormatter formateoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaActual = LocalDate.now();

        LocalDate fechaMaximaDevolucion;
        if (tipoUsuario == 1) {
            fechaMaximaDevolucion = fechaActual.plusDays(10);
        } else if (tipoUsuario == 2) {
            fechaMaximaDevolucion = fechaActual.plusDays(8);
        } else if (tipoUsuario == 3) {
            fechaMaximaDevolucion = fechaActual.plusDays(7);
        } else {
            throw new Exception("Tipo de usuario no permitido en la biblioteca");
        }

        while (fechaMaximaDevolucion.getDayOfWeek() == DayOfWeek.SATURDAY ||
                fechaMaximaDevolucion.getDayOfWeek() == DayOfWeek.SUNDAY) {

            fechaMaximaDevolucion = fechaActual.plusDays(1);
        }

    }


    @Override
    public Prestamo mostrarPrestamoPorId(Integer id) throws Exception {
        Optional<Prestamo> prestamoOpcional = prestamoRepositorio.findById(id);
        if (prestamoOpcional.isPresent()) {
            return prestamoOpcional.get();
        } else {
            throw new Exception("Prestamo no encontrado");
        }
    }



}
