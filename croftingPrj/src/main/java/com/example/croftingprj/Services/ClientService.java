package com.example.croftingprj.Services;

import com.example.croftingprj.Entities.Client;

import java.util.Optional;

public interface ClientService {
    Client save(Client client);
    Optional<Client> findOne(Long id);
    Client findByEmail(String email);
}
