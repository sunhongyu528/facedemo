package com.changhongit.facedemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class Hello {

    @RequestMapping("/")
    public String hello(){
        return "index";
    }

    @RequestMapping("/register")
    public String register(){
        return "faceregister";
    }

    @RequestMapping("/login")
    public String login(){
        return "facelogin";
    }


    @RequestMapping("/logout")
    public String logout(){
        return "facelogout";
    }



}
