package com.example.foodapplogin.controller;

import com.example.foodapplogin.data.UserRepository;
import com.example.foodapplogin.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {
    UserRepository repository;

    public Login(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/signup")
    ResponseEntity<String> login(@RequestParam String username,@RequestParam String password){
        Customer customer = repository.getUser(username);
        if (customer != null){
            if(customer.getPassword().equals(password)){
                return ResponseEntity.ok(customer.getId() + "");
            }else {
                return ResponseEntity.badRequest().build();
            }
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/signup")
    ResponseEntity<String> register(@RequestParam String username,@RequestParam String password,@RequestParam String email){
        Customer customer = new Customer(username,password,email);
        try{
            repository.save(customer);
            return ResponseEntity.ok("Użytkownik dodany");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().build();
        }
    }
}
