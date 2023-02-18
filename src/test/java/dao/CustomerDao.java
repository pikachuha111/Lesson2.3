package dao;

import models.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class CustomerDao {

    public Customer findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Customer.class, id);
    }

    public void save(Customer user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession(); //create session
        Transaction tx1 = session.beginTransaction(); // should be open and close , also control that no lose data between data and client
        session.save(user);
        tx1.commit(); //equals that we push the button save
        session.close(); //close session
    }

    public void update(Customer user) {

    }

    public void delete(Customer user) {

    }

    public List<Customer> finAll() {
        List<Customer> customerList = HibernateSessionFactoryUtil.getSessionFactory().openSession()
                .createQuery("From customer").list();

        return customerList;
    }
}
