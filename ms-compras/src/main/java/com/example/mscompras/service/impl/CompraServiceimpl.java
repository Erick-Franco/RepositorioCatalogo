package com.example.mscompras.service.impl;

import com.example.mscompras.entity.Compra;
import com.example.mscompras.repository.CompraRepository;
import com.example.mscompras.service.CompraService;
import com.github.andrewoma.dexx.collection.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class CompraServiceimpl implements CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Override
    public List<Compra> listar() {
        return compraRepository.findAll();
    }

    @Override
    public Optional<Compra> buscar(Integer id) {
        return compraRepository.findById(id);
    }

    @Override
    public Compra guardar(Compra compra) {
        return compraRepository.save(compra);
    }

    @Override
    public Compra actualizar(Integer id, Compra compra) {
        return compraRepository.save(compra);
    }

    @Override
    public void eliminar(Integer id) {
        compraRepository.deleteById(id);
    }

    @Override
    public Optional<Compra> filtrarCompras(Integer id, String nombre, String fecha) {
        return Optional.empty();
    }
}


