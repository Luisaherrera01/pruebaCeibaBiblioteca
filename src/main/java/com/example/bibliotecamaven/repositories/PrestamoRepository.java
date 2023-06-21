package com.example.bibliotecamaven.repositories;

import com.example.bibliotecamaven.entities.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo,Integer> {
    //funcion propia de jpa que va a la entidad y la llave primaria
    //este es una funcion propia
    boolean existsByIdentificacionUsuario(String identificacionUsuario);


}
