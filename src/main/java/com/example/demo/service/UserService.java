package com.example.demo.service;

import com.example.demo.cache.UserCache;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.example.demo.exception.UserNotFoundException;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserCache userCache;
    public UserService(UserRepository userRepository, UserCache userCache) {
        this.userRepository = userRepository;
        this.userCache = userCache;
    }

    public User getUserById(Integer id) {
        User user = userCache.getOrNull(id);
        if(user != null) return user;
        user = userRepository.findById(id).orElse(null);
        if(user != null) userCache.addCache(id,user);
        if(user == null){
            throw new UserNotFoundException("用户不存在，id:"+id);
        }
        return user;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}