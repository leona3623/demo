package com.example.demo.cache;

import com.example.demo.entity.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class UserCache {
    private Map<Integer, User> cache = new HashMap<>();
    public void addCache(Integer id,User user){
        cache.put(id,user);
    }
    public User getCache(Integer id){
        return cache.get(id);
    }
    public void removeCache(Integer id){
        cache.remove(id);
    }
    public boolean contains(Integer id){
        return cache.containsKey(id);
    }
    public User getOrNull(Integer id){
        if(cache.containsKey(id)){
            System.out.println("缓存命中");
            return cache.get(id);
        }
        else {
            System.out.println("缓存未命中");
            return null;
        }
    }
    public void printSize(){
        System.out.println("当前缓存有"+cache.size()+"个User");
    }
}
