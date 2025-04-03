package com.example.mscompras.util;

import com.example.mscompras.entity.Compra;
import com.example.mscompras.repository.CompraRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CompraSeeder implements CommandLineRunner {

    private final CompraRepository compraRepository;

    public CompraSeeder(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    @Override
    public void run(String... args) {
        // Verificamos si ya existen datos para no duplicar
        if (compraRepository.count() == 0) {
            Compra compra1 = new Compra(null, "Compra A", "2025-04-01", 1000.0);
            Compra compra2 = new Compra(null, "Compra B", "2025-04-02", 1500.0);
            Compra compra3 = new Compra(null, "Compra C", "2025-04-03", 2000.0);
            Compra compra4 = new Compra(null, "Compra D", "2025-04-04", 2500.0);
            Compra compra5 = new Compra(null, "Compra E", "2025-04-05", 3000.0);

            compraRepository.save(compra1);
            compraRepository.save(compra2);
            compraRepository.save(compra3);
            compraRepository.save(compra4);
            compraRepository.save(compra5);

            System.out.println("Datos de compras insertados correctamente.");
        } else {
            System.out.println("Las compras ya existen, no se insertaron datos.");
        }
    }
}
