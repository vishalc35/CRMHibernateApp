package com.amazon.crmhibernateapp.controller;

import com.amazon.crmhibernateapp.model.Customer;
import com.amazon.crmhibernateapp.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
@Slf4j
public class CustomerController {
    // need to inject the customer dao
    @Autowired
    private CustomerService customerService;



    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Customer theCustomer = new Customer();


        //WE use this attribute name in html form to bind data
        //We use this so that whatever value user enters in the form that are bind to fields of customer , they are then
        // stored as object in model data and binded to "customer" attribute
        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

        // save the customer using our service
        customerService.saveCustomer(theCustomer);


        return "redirect:/customer/list";
    }




    @RequestMapping("/list")
    public String listCustomers(Model theModel) {

        List<Customer> theCustomers = customerService.getCustomers();

        log.info("Vishal customers"+theCustomers);

        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }

}
