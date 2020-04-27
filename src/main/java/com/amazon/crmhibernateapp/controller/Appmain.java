package com.amazon.crmhibernateapp.controller;

import com.amazon.crmhibernateapp.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Appmain {

    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();


        try {

            /**
             * Follwoing first 2 cases gives one directional mapping . Meaining if we delete or perform any operation on
             * instructor it will affect instructor detail but not other way round
             * */

            session.beginTransaction();

            Customer customer = session.get(Customer.class,1);

            System.out.println("Vishal"+customer.getEmail());

            session.getTransaction().commit();

            System.out.println("Done!!!");

        }
        finally {
            session.close();
            factory.close();
        }

    }
}
