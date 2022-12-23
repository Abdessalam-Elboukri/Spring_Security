package com.example.croftingprj.Services;

public interface AuthService {
    boolean clientLogin(String email, String password);

    boolean stockLogin(String email, String password);
}


