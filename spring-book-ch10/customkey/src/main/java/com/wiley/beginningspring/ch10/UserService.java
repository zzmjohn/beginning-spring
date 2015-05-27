package com.wiley.beginningspring.ch10;

import org.springframework.cache.annotation.Cacheable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mertcaliskan
 * on 18/08/14.
 */
public class UserService {

    private Map<Integer, User> users = new HashMap<Integer, User>();
    {
        users.put(1, new User(1, 11122233344L, "Kenan", "5554332088", 37));
        users.put(2, new User(2, 23451323454L, "Mert", "5552345060", 34));
    }

    @Cacheable(value = "users", key = "#user.nationalId")
    public User getUser(User user) {
        System.out.println("User with id " + user.getId() + " requested.");
        return users.get(user.getId());
    }
}
