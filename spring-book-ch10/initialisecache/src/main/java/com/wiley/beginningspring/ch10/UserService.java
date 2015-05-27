package com.wiley.beginningspring.ch10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mertcaliskan
 * on 18/08/14.
 */
@Service
public class UserService {

    private Map<Integer, User> users = new HashMap<>();
    {
        users.put(1, new User(1, "Kenan"));
        users.put(2, new User(2, "Mert"));
    }

    @Autowired
    private CacheManager cacheManager;

    @PostConstruct
    public void setup() {
        Cache usersCache = cacheManager.getCache("users");
        for (Integer key : users.keySet()) {
            usersCache.put(key, users.get(key));
        }
    }

    @Cacheable(value = "users")
    public User getUser(int id) {
        System.out.println("User with id " + id + " requested.");
        return users.get(id);
    }
}
