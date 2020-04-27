package com.amazon.crmhibernateapp.dao;

import com.amazon.crmhibernateapp.model.Customer;
import com.amazon.crmhibernateapp.utils.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository // Usually used with Dao imolementation
public class CustomerDAOImpl implements CustomerDAO {

    @Override
//    @Transactional--- we removed this because we are delegating calls from CustomerserviceImpl and we added this anotation ther
    public List<Customer> getCustomers() {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session currentSession = factory.getCurrentSession();

        currentSession.beginTransaction();
        // create a query
        Query<Customer> theQuery =
                currentSession.createQuery("from Customer order by lastName", Customer.class);

        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();

        currentSession.getTransaction().commit();

        currentSession.close();
        factory.close();

        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session currentSession = factory.getCurrentSession();

        currentSession.beginTransaction();
        currentSession.save(theCustomer);

        currentSession.getTransaction().commit();

        currentSession.close();
        factory.close();

    }
}






