package com.wiley.beginningspring.ch11.repository;

import com.wiley.beginningspring.ch11.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mertcaliskan
 * on 22/09/14.
 */
@Repository
public class UserRepository {

    private Map<Integer, User> users = new HashMap<Integer, User>();

    @PostConstruct
    public void setup() {
        users.put(1, new User(1, "Mert Caliskan"));
        users.put(2, new User(2, "Kenan Sevindik"));
    }

    public void save(User user) {
        users.put(user.getId(), user);
    }

    public List<User> findAll() {
        return new ArrayList<User>(users.values());
    }

    public User find(int id) {
        return users.get(id);
    }

    public void update(int id, User user) {
        users.put(id, user);
    }

    public void delete(int id) {
        users.remove(id);
    }
}
