package com.base;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//@Configuration
//If I decide to use a property source @PropertySource("classpath:??????.properties")
public class ConfigClass {
    /*
    Cannot create constructor for Employee because of autowiring rules. See below solution
    TODO: Implement Hibernate to authenticate through SQL and create a separate interface to update data
     */

    //@Bean
    public User employee(){
        return new Employee("Test");
    }


}