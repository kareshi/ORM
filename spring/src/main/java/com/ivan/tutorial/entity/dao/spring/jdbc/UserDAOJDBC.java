package com.ivan.tutorial.entity.dao.spring.jdbc;

import com.ivan.tutorial.entity.User;
import com.ivan.tutorial.entity.dao.UserDAO;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class UserDAOJDBC implements UserDAO {

    private DataSource dataSource;

    public void save(User user) {
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
