package com.project.jukebox.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.project.jukebox.entities.User;

public class UserRepository implements IUserRepository{

    private Map<String,User> userMap;
    private Integer autoIncrement = 0;

    public UserRepository(){
        userMap = new HashMap<String,User>();
    }

    public UserRepository(Map<String,User> userMap) {
        this.userMap = userMap;
        this.autoIncrement = userMap.size();
    }

    @Override
    public User save(User entity) {
        
        if( entity.getId() == null){
            autoIncrement++;
            User u = new User(Integer.toString(autoIncrement),entity.getName());
            userMap.put(u.getId(),u);
            return u;
        }
        userMap.put(entity.getId(),entity);
        return entity;
    }

    public List<User> findAll() {
        List<User> allUser = new ArrayList<>();
            for(User each : userMap.values()){
                allUser.add(each);
            }
     return allUser;
    }


    @Override
    public User findById(String id) {
        return userMap.get(id);
    }

    @Override
    public boolean existsById(String id) {
        for(User each : userMap.values()){
            if(each.getId().equals(id))
            return true;
        }  
        return false;
    }

    @Override
    public void delete(User entity) {
        
        if(userMap.containsValue(entity)){
            String foundKey = null;
            for (Map.Entry<String, User> entry : userMap.entrySet()) {
                if (entry.getValue().equals(entity)) {
                    foundKey = entry.getKey();
                    break;
                }
            }
            userMap.remove(foundKey);
            } 
    }

    @Override
    public void deleteById(String id) {
        
        for(User each : userMap.values()){
            if(each.getId().equals(id)){
                String foundKey = null;
            for (Map.Entry<String, User> entry : userMap.entrySet()) {
                if (entry.getValue().getId().equals(id)) {
                    foundKey = entry.getKey();
                    break;
                }
            }
            userMap.remove(foundKey);
        }   
    }
    }

    @Override
    public long count() {
        return userMap.size();
    }

    @Override
    public Optional<User> findByName(String name) {
        for(User u : userMap.values()){
            if(u.getName()==name)
            return Optional.of(u);
        }
    return Optional.ofNullable(null);
    }
    
}
