package com.ivan.tutorial.entity;

import com.ivan.tutorial.entity.Authority;
import com.ivan.tutorial.entity.User;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: ivan
 * Date: 3/24/12
 * Time: 7:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserUtil {
    
    public static User createUser() {

        User user = new User();

        user.setName("Ivan");
        user.setPassword("Chio");
        user.setCreatedBy("Bonaf");
        user.setCreatedOn(new Date());

        Authority authority = new Authority();
        Set<Authority> authorities = new HashSet<Authority>();
        authorities.add(authority);
        authority.setName("ADMIN");

        authority.setUser(user);

        user.setAuthorities(authorities);
        return user;

    }
    
}
