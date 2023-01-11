package com.example.foodapplogin.data;

import com.example.foodapplogin.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class UserRepository {
    UserData data;

    public UserRepository(UserData data) {
        this.data = data;
    }

    public void save(Customer customer){
        data.save(customer);
    }

    public Customer getUser(String username){
        return data.getCustomerByUsername(username);
    }

    public Customer getUserByEmail(String email){
        return data.getCustomerByEmail(email);
    }

    public void removeUser(Customer customer){
        data.delete(customer);
    }
}
