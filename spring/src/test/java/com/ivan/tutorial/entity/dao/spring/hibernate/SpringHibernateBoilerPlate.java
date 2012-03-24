package com.ivan.tutorial.entity.dao.spring.hibernate;

import com.ivan.tutorial.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SpringHibernateBoilerPlate {

    private SessionFactory sessionFactory;
    @Before
    public void setUp() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-hibernate.xml");
        sessionFactory = (SessionFactory)applicationContext.getBean("sessionFactory");
    }

    @Test
    public void addUser() {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        User user = new User();

        user.setName("Ivanaf");
        user.setPassword("Chionaf");
        user.setCreatedBy("Bonaf");
        user.setCreatedOn(new Date());

        session.save(user);
        session.getTransaction().commit();

        assertThat(session.contains(user), is(true));
        
    }

}
