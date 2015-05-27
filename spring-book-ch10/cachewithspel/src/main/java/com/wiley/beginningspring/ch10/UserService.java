package com.wiley.beginningspring.ch10;

import org.springframework.cache.annotation.Cacheable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mertcaliskan
 * on 18/08/14.
 */
public class UserService {

    private Map<Integer, User> users = new HashMap<Integer, User>();
    {
        users.put(1, new User(1, "Kenan"));
        users.put(2, new User(2, "Mert"));
    }

    @Cacheable(value = "users1", condition = "#root.methodName == 'getUser1'")
    public User getUser1(int id) {
        System.out.println("User with id " + id + " requested.");
        return users.get(id);
    }

    @Cacheable(value = "users2", condition = "#root.method.returnType.name == 'com.wiley.beginningspring.ch10.User'")
    public User getUser2(int id) {
        System.out.println("User with id " + id + " requested.");
        return users.get(id);
    }

    @Cacheable(value = "users3", condition = "#root.target instanceof T(com.wiley.beginningspring.ch10.UserService)")
    public User getUser3(int id) {
        System.out.println("User with id " + id + " requested.");
        return users.get(id);
    }

    @Cacheable(value = "users4", condition = "#root.targetClass.name == 'com.wiley.beginningspring.ch10.UserService'")
    public User getUser4(int id) {
        System.out.println("User with id " + id + " requested.");
        return users.get(id);
    }

    @Cacheable(value = "users5", condition = "#root.args[0] == 1")
    public User getUser5(int id) {
        System.out.println("User with id " + id + " requested.");
        return users.get(id);
    }

    @Cacheable(value = "users6", condition = "#root.caches[0].name == 'users6'")
    public User getUser6(int id) {
        System.out.println("User w  ith id " + id + " requested.");
        return users.get(id);
    }

    @Cacheable(value = "users7", unless = "#result.name == 'Kenan'")
    public User getUser7(int id) {
        System.out.println("User with id " + id + " requested.");
        return users.get(id);
    }

    @Cacheable(value = "users8", condition = "#p0 == 1")
    public User getUser8(int id) {
        System.out.println("User with id " + id + " requested.");
        return users.get(id);
    }

    @Cacheable(value = "users9", condition = "#id == 1")
    public User getUser9(int id) {
        System.out.println("User with id " + id + " requested.");
        return users.get(id);
    }
}