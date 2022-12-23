package com.example.croftingprj.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.croftingprj.Config.JwtUtils;
import com.example.croftingprj.Entities.Client;
import com.example.croftingprj.Entities.DTO.AuthRequest;
import com.example.croftingprj.Entities.Stock;
import com.example.croftingprj.Services.AuthService;
import com.example.croftingprj.Services.ClientService;
import com.example.croftingprj.Services.StockService;
import com.example.croftingprj.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    JwtUtils jwtUtils;


    @PostMapping("/client/login")
    public ResponseEntity<String> auth(@RequestBody AuthRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
        UserDetails user = userService.findByEmail(request.getEmail());
        if(user != null) {
            System.out.println(jwtUtils.generateToken(user));
            return ResponseEntity.ok(jwtUtils.generateToken(user));

        }else
            return ResponseEntity.status(400).body("error");
    }







}
