package com.ivan.tutorial.entity.dao;

import com.ivan.tutorial.entity.User;

import java.util.List;

public interface UserDAO {

    void create(User user);

    List<User> selectAll();


}
