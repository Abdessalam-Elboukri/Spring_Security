package com.example.croftingprj.Services;

import com.example.croftingprj.Entities.Stock;

import java.util.List;
import java.util.Optional;

public interface StockService {
    Stock save(Stock stock);

    Stock findByEmail(String email);

    List<Stock> getAll();

    Optional<Stock> findById(int id);
}
