package com.example.mscompras.controller;

import com.example.mscompras.entity.Compra;
import com.example.mscompras.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mscompras.repository.CompraRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private CompraService compraService;

    @RequestMapping
    public List<Compra> listar() {
        return compraService.listar(); // Devuelve todas las compras
    }

    @RequestMapping("/{id}")
    public Optional<Compra> buscar(@PathVariable Integer id) {
        return compraService.buscar(id); // Busca una compra por ID
    }

    @PostMapping
    public Compra guardar(@RequestBody Compra compra) {
        return compraService.guardar(compra); // Guarda una nueva compra
    }

    @PutMapping("/{id}")
    public Compra actualizar(@PathVariable Integer id, @RequestBody Compra compra) {
        return compraService.actualizar(id, compra); // Actualiza una compra existente
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        compraService.eliminar(id); // Elimina una compra por ID
    }

    @GetMapping("/filtrar")
    public List<Compra> filtrarCompras(@RequestParam(required = false) Integer id,
                                       @RequestParam(required = false) String nombre,
                                       @RequestParam(required = false) String fecha) {
        if (id != null) {
            return compraRepository.findById(id).map(List::of).orElseGet(ArrayList::new);
        } else if (nombre != null && fecha != null) {
            return compraRepository.findByNombreContainingIgnoreCaseAndFecha(nombre, fecha);
        } else if (nombre != null) {
            return compraRepository.findByNombreContainingIgnoreCase(nombre);
        } else if (fecha != null) {
            return compraRepository.findByFecha(fecha);
        }
        return compraRepository.findAll();
    }





}