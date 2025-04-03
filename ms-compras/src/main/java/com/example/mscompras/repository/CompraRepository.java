package com.example.mscompras.repository;


import com.example.mscompras.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {
    List<Compra> findByNombreContainingIgnoreCase(String nombre);
    List<Compra> findByFecha(String fecha);
    List<Compra> findByNombreContainingIgnoreCaseAndFecha(String nombre, String fecha);

}