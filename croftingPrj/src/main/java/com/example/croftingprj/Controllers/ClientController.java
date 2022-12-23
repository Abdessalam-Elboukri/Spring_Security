package com.example.croftingprj.Controllers;


import com.example.croftingprj.Entities.Client;
import com.example.croftingprj.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/profile")
    public String getProfile(Model model){
        model.addAttribute("message" , "it's works");
        return "profile";
    }

}
