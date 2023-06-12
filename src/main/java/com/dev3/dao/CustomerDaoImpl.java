package com.dev3.dao;

import com.dev3.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    //need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        String hqlQuery = "FROM Customer";
        List<Customer> customers = session.createQuery(hqlQuery, Customer.class).getResultList();

        for (Customer w : customers) {
            System.out.println(w);
        }

        tx.commit();
        session.close();

        return customers;
    }

    @Override
    public void saveCustomerDao(Customer theCustomer) {
        // get current hibernate session
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.saveOrUpdate(theCustomer);

        tx.commit();
        session.close();
    }

    @Override
    public Customer getCustomer(int theId) {

        //get the current hibernate session

        //now retrieve/read form database using the primary key

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Customer theCustomer = session.get(Customer.class, theId);

        tx.commit();
        session.close();

        return theCustomer;
    }

    @Override
    public void deleteCustomer(int theId) {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Query theQuery = session.createQuery("delete from Customer where id=:customerId");
        theQuery.setParameter("customerId", theId);
        theQuery.executeUpdate();


        tx.commit();
        session.close();


    }
}
