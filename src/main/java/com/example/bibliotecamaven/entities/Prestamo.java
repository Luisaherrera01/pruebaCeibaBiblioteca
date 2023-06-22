package com.example.bibliotecamaven.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table (name = "Prestamos")
public class Prestamo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(length = 10, nullable = false)
    private String isbn;
    @Column(length = 10, nullable = false)
    private String identificacionUsuario;
    @Column(nullable = false)
    private Integer tipoUsuario;

    @Column(nullable = false)
    private LocalDate fechaMaximaDevolucion;


    public Prestamo() {
    }


    public Prestamo(Integer id, String isbn, String identificacionUsuario, Integer tipoUsuario, LocalDate fechaMaximaDevolucion) {
        this.id = id;
        this.isbn = isbn;
        this.identificacionUsuario = identificacionUsuario;
        this.tipoUsuario = tipoUsuario;
        this.fechaMaximaDevolucion = fechaMaximaDevolucion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public void setIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    public Integer getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Integer tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public LocalDate getFechaMaximaDevolucion() {
        return fechaMaximaDevolucion;
    }

    public void setFechaMaximaDevolucion(LocalDate fechaMaximaDevolucion) {
        this.fechaMaximaDevolucion = fechaMaximaDevolucion;
        
    }


}
