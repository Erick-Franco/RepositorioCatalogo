package com.example.msclientes.repository;

import com.example.msclientes.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    List<Cliente> findByNombresContainingIgnoreCase(String nombres);
    List<Cliente> findByCorreo(String correo);
    List<Cliente> findByNombresContainingIgnoreCaseAndCorreo(String nombres, String correo);
}
