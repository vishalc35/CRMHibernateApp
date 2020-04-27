package com.amazon.crmhibernateapp.service;

import com.amazon.crmhibernateapp.dao.CustomerDAO;
import com.amazon.crmhibernateapp.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    // need to inject customer dao
    @Autowired
    private CustomerDAO customerDAO;


    /**
     *
     * Here we are delegating calls to Dao. But we can add another methods in service for differnt use cases
     * **/
    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {

        customerDAO.saveCustomer(theCustomer);
    }
}
