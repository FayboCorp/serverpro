package com.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Logic {

    /*
    TODO: Start using dependency injection
     */
    private Map<String, User> userNames;
    private Map<String, String> passwords;
    private List<String> list = new ArrayList<>();

    public Logic(){
        userNames = new HashMap<>();
        passwords = new HashMap<>();
        userNames.put("fabian", new Employee("fabian"));
        passwords.put("fabian", "12345");
    }

    public List<String> getList(){
        return list;
    }

    public void addUser(Employee user, String password){
        userNames.put(user.getName(), user);
        passwords.put(user.getName(), password);
    }

    public boolean getAuthentication(String userName, String password){
        if(userNames.get(userName) != null){
            if(passwords.get(userName).equals(password)){
                return true;
            }
        }
        return false;
    }
}
