package com.example.msclientes.util;

import com.example.msclientes.entity.Cliente;
import com.example.msclientes.repository.ClienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ClienteSeeder implements CommandLineRunner {

    private final ClienteRepository clienteRepository;

    public ClienteSeeder(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void run(String... args) {
        // Verificamos si ya existen datos para no duplicar
        if (clienteRepository.count() == 0) {
            Cliente cliente1 = new Cliente(null, "Juan", "Pérez", "juan.perez@example.com", "123456789");
            Cliente cliente2 = new Cliente(null, "Ana", "Gómez", "ana.gomez@example.com", "987654321");
            Cliente cliente3 = new Cliente(null, "Luis", "Martínez", "luis.martinez@example.com", "1122334455");
            Cliente cliente4 = new Cliente(null, "Maria", "Sánchez", "maria.sanchez@example.com", "5566778899");
            Cliente cliente5 = new Cliente(null, "Carlos", "Rodríguez", "carlos.rodriguez@example.com", "6677889900");

            clienteRepository.save(cliente1);
            clienteRepository.save(cliente2);
            clienteRepository.save(cliente3);
            clienteRepository.save(cliente4);
            clienteRepository.save(cliente5);

            System.out.println("Datos de clientes insertados correctamente.");
        } else {
            System.out.println("Los clientes ya existen, no se insertaron datos.");
        }
    }
}
