package com.example.bibliotecamaven.controllers;

import com.example.bibliotecamaven.entities.Prestamo;
import com.example.bibliotecamaven.services.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

    @Autowired
    protected PrestamoService prestamoServicio;

    @PostMapping
    public ResponseEntity<Prestamo> registrar(@RequestBody Prestamo prestamo){
        try {
            Prestamo prestamoRegistrado= prestamoServicio.registrar(
                    prestamo.getIsbn(),
                    prestamo.getIdentificacionUsuario(),
                    prestamo.getTipoUsuario(),
                    prestamo.getFechaMaximaDevolucion()
            );
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(prestamoRegistrado);
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Prestamo>mostrarPrestamo(@PathVariable Integer id){
        try {
            Prestamo prestamoEncontrado=prestamoServicio.mostrarPrestamoPorId(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(prestamoEncontrado);
        }catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }
}
