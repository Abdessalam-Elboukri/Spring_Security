package com.example.croftingprj.Controllers;


import com.example.croftingprj.Entities.Client;
import com.example.croftingprj.Entities.Users;
import com.example.croftingprj.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/client/register")
    public Users register(@RequestBody Client client){
        return userService.save(client);
    }
}
