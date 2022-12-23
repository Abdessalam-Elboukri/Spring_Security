package com.example.croftingprj.Services.Imp;

import com.example.croftingprj.Entities.Stock;
import com.example.croftingprj.Repository.StockRepository;
import com.example.croftingprj.Services.StockService;
import com.example.croftingprj.Utils.PasswordHasher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImp implements StockService {

    @Autowired
    StockRepository stockRepository;

    @Override
    public Stock save(Stock stock) {
        if(stock==null) {
            throw new IllegalArgumentException("stock is null");
        }
        if(stock.getFirstName()==null || stock.getLastName()==null || stock.getEmail()==null || stock.getPhone()==null || stock.getPassword()==null || stock.getAdresse()==null){
            throw new IllegalArgumentException("Please fill all stock information");
        }else{
            stock.setPassword(PasswordHasher.hash(stock.getPassword()));
            return stockRepository.save(stock);
        }
    }

    @Override
    public Stock findByEmail(String email) {
        return stockRepository.findByEmail(email);
    }

    @Override
    public List<Stock> getAll() {
        return stockRepository.findAll();
    }

    @Override
    public Optional<Stock> findById(int id) {
        return stockRepository.findById(id);
    }
}
