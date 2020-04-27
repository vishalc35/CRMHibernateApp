package com.amazon.crmhibernateapp.service;

import com.amazon.crmhibernateapp.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);
}