package com.example.croftingprj.Controllers;


import com.example.croftingprj.Entities.Stock;
import com.example.croftingprj.Services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stock")
public class StockController {

    @Autowired
    StockService stockService;

    @GetMapping("/new")
    public String addStock(){
        return "add_stock";
    }

    @PostMapping("/new")
    public String addStock(@ModelAttribute("stock")Stock stock){
        stockService.save(stock);
        return "redirect:/new";
    }




}
