package com.ivan.tutorial.entity.dao.spring.jdbc;

import com.ivan.tutorial.entity.User;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserDAOJDBCTest {

    private DataSource datasource;
    private UserDAOJDBC daoJdbc;

    @Before
    public void setUp() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-hibernate.xml");
        datasource = (DataSource)applicationContext.getBean("dataSource");
        daoJdbc = new UserDAOJDBC();
        daoJdbc.setDataSource(datasource);
    }

    @Test
    public void addUser() {

        User user = new User();

        user.setName("Ivanaf");
        user.setPassword("Chionaf");
        user.setCreatedBy("Bonaf");
        user.setCreatedOn(new Date());

        daoJdbc.save(user);
        List<User> users = daoJdbc.selectAll();
        
        assertThat(users.size(), is(1));
        User userFetched = users.get(0);
        assertThat(userFetched.getId(), is(1L));
        assertThat(userFetched.getName(), is(user.getName()));
        assertThat(userFetched.getPassword(), is(user.getPassword()));
    }

}
