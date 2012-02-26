package com.hsbc.gbm.cash.clearing.data.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: ivan
 * Date: 2/26/12
 * Time: 4:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class SpringHibernateBoilerPlate {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-hibernate.xml");
        SessionFactory sessionFactory = (SessionFactory)applicationContext.getBean("sessionFactory");

        Session session = sessionFactory.openSession();

        session.beginTransaction();
        User user = new User();

        user.setName("Ivanaf");
        user.setPassword("Chionaf");
        user.setCreatedBy("Bonaf");
        user.setCreatedOn(new Date());

        session.save(user);
        session.getTransaction().commit();
    }
}
