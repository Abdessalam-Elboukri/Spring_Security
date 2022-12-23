package com.example.croftingprj.Services.Imp;

import com.example.croftingprj.Entities.Client;
import com.example.croftingprj.Entities.Stock;
import com.example.croftingprj.Services.AuthService;
import com.example.croftingprj.Services.ClientService;
import com.example.croftingprj.Services.StockService;
import com.example.croftingprj.Utils.PasswordHasher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImp implements AuthService {
    @Autowired
    ClientService clientService;

    @Autowired
    StockService stockService;

    @Override
    public boolean clientLogin(String email, String password) {
        Client client = clientService.findByEmail(email);
        if(client == null)
            return false;
        else if(client.getEmail() == null)
            return false;
        else
            return PasswordHasher.verify(client.getPassword(), password);

        }

    @Override
    public boolean stockLogin(String email, String password) {
        Stock stock = stockService.findByEmail(email);
        if(stock == null)
            return false;
        else if(stock.getEmail() == null)
            return false;
        else
            return PasswordHasher.verify(stock.getPassword(), password);
    }

}
