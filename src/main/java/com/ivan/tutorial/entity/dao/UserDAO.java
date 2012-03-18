package com.ivan.tutorial.entity.dao;

import com.ivan.tutorial.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class UserDAO {

    private DataSource dataSource;

    public void create(User user) {
        JdbcTemplate insert = new JdbcTemplate(dataSource);
        insert.update("INSERT INTO USERS (ID, CREATEDBY, CREATEDON, NAME, PASSWORD) VALUES(?,?,?,?,?)",
                new Object[] { user.getId(), user.getCreatedBy(), user.getCreatedOn(), user.getName(), user.getPassword() });
    }

    public List<User> selectAll() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("SELECT * FROM USERS", new UserRowMapper());
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
