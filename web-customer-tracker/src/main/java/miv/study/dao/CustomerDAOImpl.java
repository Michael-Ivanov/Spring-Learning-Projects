package miv.study.dao;

import miv.study.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;  // todo: try to change autowired to constructor

    @Override
    public List<Customer> getCustomers() {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        // create a query
        Query<Customer> query = currentSession.createQuery("from Customer", Customer.class);
        // execute query and get result list
        List<Customer> customers = query.getResultList();
        // return the results
        return customers;
    }
}
