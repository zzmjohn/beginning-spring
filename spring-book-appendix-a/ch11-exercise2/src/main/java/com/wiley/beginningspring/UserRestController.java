package com.wiley.beginningspring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mertcaliskan
 * on 24/11/14.
 */
@RestController
@RequestMapping("/rest")
public class UserRestController {

    @RequestMapping(value = "/users", method= RequestMethod.GET)
    public List<User> list() {
        List<User> users = new ArrayList<User>();
        users.add(new User(1, "Mert Caliskan", "Izmir"));
        users.add(new User(2, "Kenan Sevindik", "Ankara"));
        return users;
    }
}
