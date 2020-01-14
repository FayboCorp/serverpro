package com.base;

import org.springframework.stereotype.Component;


public class Employee implements User {


    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean sendTask() {
        return false;
    }

    @Override
    public boolean deleteTask() {
        return false;
    }

    @Override
    public boolean moveTaskUp() {
        return false;
    }

    @Override
    public boolean moveTaskDown() {
        return false;
    }

    @Override
    public boolean moveTaskTop() {
        return false;
    }

    @Override
    public Task createTask() {
        return null;
    }
}
