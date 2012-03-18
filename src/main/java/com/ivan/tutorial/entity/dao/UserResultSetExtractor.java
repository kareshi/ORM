package com.ivan.tutorial.entity.dao;


import com.ivan.tutorial.entity.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserResultSetExtractor implements ResultSetExtractor {

    @Override
    public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        User user = new User();
        user.setId(resultSet.getLong(1));
        user.setCreatedBy(resultSet.getString(2));
        user.setCreatedOn(resultSet.getDate(3));
        user.setName(resultSet.getString(4));
        user.setPassword(resultSet.getString(5));

        return user;
    }
}
