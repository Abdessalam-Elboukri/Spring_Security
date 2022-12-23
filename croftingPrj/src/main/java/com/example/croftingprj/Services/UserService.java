package com.example.croftingprj.Services;

import com.example.croftingprj.Entities.Users;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    Users save(Users user);

    UserDetails findByEmail(String email);
}
