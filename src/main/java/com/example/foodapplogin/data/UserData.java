package com.example.foodapplogin.data;

import com.example.foodapplogin.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserData extends CrudRepository<Customer, Integer> {
    Customer getCustomerByEmail(String email);

    Customer getCustomerByUsername(String username);
}
