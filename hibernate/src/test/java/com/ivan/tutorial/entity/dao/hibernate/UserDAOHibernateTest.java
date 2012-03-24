package com.ivan.tutorial.entity.dao.hibernate;

import com.ivan.tutorial.entity.Authority;
import com.ivan.tutorial.entity.User;

import com.ivan.tutorial.entity.UserUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.internal.matchers.IsCollectionContaining.hasItem;

public class UserDAOHibernateTest {

    private SessionFactory sessionFactory ;
    private UserDAOHibernate userDAOHibernate ;
    private User user;

    @Before
    public void setUp() {
        // Create the SessionFactory from hibernate.cfg.xml
        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        userDAOHibernate = new UserDAOHibernate();
        userDAOHibernate.setSessionFactory(sessionFactory);
        user = UserUtil.createUser();
    }

    @After
    public void shutdown() {
        // Close caches and connection pools
        sessionFactory.close();
    }

    @Test
    public void addUser() {
        userDAOHibernate.save(user);
        List<User> users = userDAOHibernate.selectAll();
//        assertThat(users, hasItem(user));
    }

}

