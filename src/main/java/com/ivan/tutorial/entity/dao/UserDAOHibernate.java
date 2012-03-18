package com.ivan.tutorial.entity.dao;

import com.ivan.tutorial.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.List;

public class UserDAOHibernate implements UserDAO {

    private HibernateTemplate hibernateTemplate;

    @Override
    public void create(User user) {
        hibernateTemplate.saveOrUpdate(user);
    }

    @Override
    public List<User> selectAll() {
        return hibernateTemplate.find("from User");
    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

}
