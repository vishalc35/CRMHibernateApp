package com.amazon.crmhibernateapp.dao;

import com.amazon.crmhibernateapp.model.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

}
