package com.ivan.tutorial.entity.dao;

import com.ivan.tutorial.entity.User;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserDAOHibernateTest {

    private SessionFactory sessionFactory;
    private UserDAOHibernate dao;

    @Before
    public void setUp() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/ivan/tutorial/spring/jdbc/spring-hibernate.xml");
        sessionFactory = (SessionFactory)applicationContext.getBean("sessionFactory");
        dao = new UserDAOHibernate();
        dao.setSessionFactory(sessionFactory);
    }

    @Test
    public void addUser() {

        User user = new User();

        user.setName("Ivanaf");
        user.setPassword("Chionaf");
        user.setCreatedBy("Bonaf");
        user.setCreatedOn(new Date());

        dao.create(user);
        List<User> users = dao.selectAll();

        assertThat(users.size(), is(1));
        User userFetched = users.get(0);
        assertThat(userFetched.getId(), is(1L));
        assertThat(userFetched.getName(), is(user.getName()));
        assertThat(userFetched.getPassword(), is(user.getPassword()));
    }

}
