package com.uniyaz.eticaret.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User addUser(User user) {
        return userDao.save(user);
    }

    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    public User updateUser(User user) {
        return userDao.save(user);
    }

    public void deleteUser(Long id) {
        userDao.deleteById(id);
    }
}
