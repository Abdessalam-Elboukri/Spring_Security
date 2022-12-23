package com.example.croftingprj.Services.Imp;


import com.example.croftingprj.Entities.Client;
import com.example.croftingprj.Repository.ClientRepository;
import com.example.croftingprj.Services.ClientService;
import com.example.croftingprj.Utils.PasswordHasher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImp implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Client save(Client client) {
        if(client==null) {
             throw new IllegalArgumentException("client is null");
        }
        if(client.getFirstName()==null || client.getLastName()==null || client.getEmail()==null || client.getPhone()==null || client.getPassword()==null){
            throw new IllegalArgumentException("Please fill all client information");
        }else{
            client.setPassword(PasswordHasher.hash(client.getPassword()));
            return clientRepository.save(client);
        }
    }

    @Override
    public Optional<Client> findOne(Long id) {
        if(id == null){
            throw new IllegalArgumentException("Please enter a id to search");
        }
        else if(!(id instanceof Long)){
            throw new IllegalArgumentException("Please enter a valid id");
        }else{
            return clientRepository.findById(id);
        }
    }

    @Override
    public Client findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }


}
