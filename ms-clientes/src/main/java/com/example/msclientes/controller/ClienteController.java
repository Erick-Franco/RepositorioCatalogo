package com.example.msclientes.controller;

import com.example.msclientes.entity.Cliente;
import com.example.msclientes.service.ClienteService;
import com.example.msclientes.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> buscar(@PathVariable Integer id) {
        return clienteService.buscar(id);
    }

    @PostMapping
    public Cliente guardar(@RequestBody Cliente cliente) {
        return clienteService.guardar(cliente);
    }

    @PutMapping("/{id}")
    public Cliente actualizar(@PathVariable Integer id, @RequestBody Cliente cliente) {
        return clienteService.actualizar(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        clienteService.eliminar(id);
    }

    @GetMapping("/filtrar")
    public List<Cliente> filtrarClientes(@RequestParam(required = false) Integer id,
                                         @RequestParam(required = false) String nombres,
                                         @RequestParam(required = false) String correo) {
        if (id != null) {
            return clienteRepository.findById(id).map(List::of).orElseGet(ArrayList::new);
        } else if (nombres != null && correo != null) {
            return clienteRepository.findByNombresContainingIgnoreCaseAndCorreo(nombres, correo);
        } else if (nombres != null) {
            return clienteRepository.findByNombresContainingIgnoreCase(nombres);
        } else if (correo != null) {
            return clienteRepository.findByCorreo(correo);
        }
        return clienteRepository.findAll();
    }
}
