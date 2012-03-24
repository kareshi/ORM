package com.ivan.tutorial.entity.dao;

import com.ivan.tutorial.entity.User;

import java.util.List;

public interface UserDAO {

    void save(User user);

    List<User> selectAll();


}
