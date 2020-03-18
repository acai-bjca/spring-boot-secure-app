package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Santiago Carrillo 8/21/17.
 */
@Service
public class UserServiceImpl implements UserService {
    private HashMap<String, User> users = new HashMap<String, User>();

    @Autowired
    public UserServiceImpl() {
    }

    @PostConstruct
    private void populateSampleData() {
        users.put("xyz", new User("0", "Andres", "Perez", "test@mail.com", "xyz", "password"));
        users.put("amalialfonsoc", new User("1", "Amalia", "Alfonso", "amalialfonsoc@gmail.com", "amalialfonsoc", "123"));
    }

    @Override
    public List<User> getUsers() {
        List<User> listOfValues = new ArrayList<>(users.values());
        return listOfValues;
    }

    @Override
    public User getUser(Long id) {
        return users.get(0);
    }

    @Override
    public User createUser(User user) {
        users.put(user.getUsername(), user);
        return user;
    }

    @Override
    public User findUserByEmail(String email) {
        for (User u : users.values()) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;

    }

    @Override
    public User findUserByUserName(String userName) {
        return users.get(userName);
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        return users.get(0);
    }
}
