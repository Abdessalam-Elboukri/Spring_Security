package com.example.croftingprj.Services.Imp;

import com.example.croftingprj.Entities.Users;
import com.example.croftingprj.Repository.UserRepository;
import com.example.croftingprj.Services.UserService;
import com.example.croftingprj.Utils.PasswordHasher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Users save(Users user) {
        if(user==null) {
            throw new IllegalArgumentException("user is null");
        }
        if(user.getFirstName()==null || user.getLastName()==null || user.getEmail()==null || user.getPhone()==null || user.getPassword()==null){
            throw new IllegalArgumentException("Please fill all user information");
        }else{
            //user.setPassword(PasswordHasher.hash(user.getPassword()));
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            return userRepository.save(user);
        }
    }

    @Override
    public UserDetails findByEmail(String email) {
        Users user = userRepository.findByEmail(email);
        return new User(user.getEmail(),user.getPassword(), Collections.singleton(new SimpleGrantedAuthority(user.getRole().getRoleName())));
    }
}
