package com.softai.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {

        var it = userRepository.findAll();

        var users = new ArrayList<User>();
        it.forEach(users::add);

        return users;
    }

    public User createUser(User user){
        userRepository.save(user);
        return user;
    }

    public Long count() {

        return userRepository.count();
    }

    public void deleteById(Long userId) {

        userRepository.deleteById(userId);
    }
}
