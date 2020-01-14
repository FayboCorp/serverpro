package com.base;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//Controller class handles all spring request mappings
@Controller
public class ControllerClass {

    /*
    Note: This class will undergo changes. When mySQL is incorporated,
    authentication will be a lot different. Not sure if how I am doing
    the authentication is the right way
     */

    //logic class. Handles logic methods to add users/ We might be able to make the class static
    private Logic logic = new Logic();

    //@RequestMapping("/devTest") //Used to test mapping
    public String getTest(){
        return "test";
    }

    //Home login page
    @RequestMapping("/")
    public String loginPage(){
        return "loginPage";
    }

    //Authentication

    //Remember that request param "username" is requesting the parameter from the
    //jsp page so we can modify at will. Model model passes data to the jsp page
    @RequestMapping("/authentication")
    public String loginAuthenticate(@RequestParam("username") String username,
    @RequestParam("password") String password, Model model){


        boolean userActive;
        List<String> list = logic.getList();

        /*
        //hard coded user info.
        TODO: Hibernate to authenticate vs the hardcode
        userNameActive = username.equals("fabian");
        passwordActive = password.equals("12345");
        */

        //See Logic.java. Seeing if user data is authenticated. Uses hashmap to store
        //it.
        userActive = logic.getAuthentication(username, password);

        //if not authenticated, return to login page.
        //TODO: add login page with error message of incorrect credentials
        if(!userActive){
            return "loginPage";
        }
        //If authenticated, send to home and pass those two attributes to the jsp file "home"
        else {
            model.addAttribute("username", username);
            model.addAttribute("list", list);
            return "home";
        }
    }

    //in home.jsp, there is an option that lets you add a user. This is the logic for that
    @RequestMapping("addUser")
    public String refreshHome(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              Model model){

        //See logic class
        logic.addUser(new Employee(username), password);

        model.addAttribute("message", username);

        return "homeAdded";
    }
}
