package com.ivan.tutorial.entity.dao.hibernate;

import com.ivan.tutorial.entity.User;
import com.ivan.tutorial.entity.dao.UserDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDAOHibernate implements UserDAO {

    private SessionFactory sessionFactory;

    @Override
    public void save(User user) {
        getSession().beginTransaction();
        getSession().saveOrUpdate(user);
        getSession().getTransaction().commit();
    }

    @Override
    public List<User> selectAll() {
        getSession().beginTransaction();
        return getSession().createCriteria(User.class).list();
    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
