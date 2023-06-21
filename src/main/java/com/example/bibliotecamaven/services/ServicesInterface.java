package com.example.bibliotecamaven.services;

import com.example.bibliotecamaven.entities.Prestamo;

import java.time.LocalDate;

public interface ServicesInterface<E> {
        //la E significa que es en cualquier tabla generico esto se llama generisidad

        //buscar todos / throws es que me traiga exepciones/ busquedas de lectura
        //public List<E> buscarTodos() throws Exception;

        //buscar por Id / busquedas de lectura
        //public E buscarPorId(Integer id) throws Exception;

        //registrar / va i busca en la base de datos
        //public E registrar(E datosARegistrar) throws Exception;

        //actualizar me llega id y datos que se van a actualizar
        // public E actualizar(Integer id, E datosNuevos) throws Exception;

        // delete
        //public boolean eliminar(Integer id) throws Exception;

        public E registrar(String isbn, String identificacionUsuario, Integer tipoUsuario, LocalDate fechaMaximaDevolucion ) throws Exception;

        public E mostrarPrestamoPorId(Integer id) throws Exception;

}
