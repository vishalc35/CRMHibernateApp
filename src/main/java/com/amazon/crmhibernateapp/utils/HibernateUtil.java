package com.amazon.crmhibernateapp.utils;

import com.amazon.crmhibernateapp.model.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    public static SessionFactory getSessionFactory() {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        return factory;
    }
}


