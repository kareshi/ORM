package com.ivan.tutorial.hibernate;

import com.hsbc.gbm.cash.clearing.data.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class HibernateBoilerPlate {

    private SessionFactory sessionFactory ;

    @Before
    public void setUp() {
        // Create the SessionFactory from hibernate.cfg.xml
        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    }

    @After
    public void shutdown() {
        // Close caches and connection pools
        sessionFactory.close();
    }

    @Test
    public void addUser() {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        User user = new User();

        user.setName("Ivan");
        user.setPassword("Chio");
        user.setCreatedBy("Bonaf");
        user.setCreatedOn(new Date());

        session.save(user);
        session.getTransaction().commit();

    }

}
