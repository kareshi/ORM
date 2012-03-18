package com.ivan.tutorial.entity.dao;

import com.ivan.tutorial.entity.User;
import com.ivan.tutorial.entity.dao.UserDAO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserDAOTest {

    private DataSource datasource;

    @Before
    public void setUp() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/ivan/tutorial/spring/jdbc/spring-hibernate.xml");
        datasource = (DataSource)applicationContext.getBean("dataSource");
    }

    @Test
    public void addUser() {

        User user = new User();

        user.setName("Ivanaf");
        user.setPassword("Chionaf");
        user.setCreatedBy("Bonaf");
        user.setCreatedOn(new Date());

        UserDAO dao = new UserDAO();
        dao.setDataSource(datasource);
        dao.create(user);
        List<User> users = dao.selectAll();
        
        assertThat(users.size(), is(1));
        User userFetched = users.get(0);
        assertThat(userFetched, equalTo(user));
        assertThat(userFetched.getId(), is(1L));
        assertThat(userFetched.getName(), is(user.getName()));
        assertThat(userFetched.getPassword(), is(user.getPassword()));
    }

}
