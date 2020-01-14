package com.base;

public interface User {

    boolean sendTask();
    boolean deleteTask();
    boolean moveTaskUp();
    boolean moveTaskDown();
    boolean moveTaskTop();
    Task createTask();

}
