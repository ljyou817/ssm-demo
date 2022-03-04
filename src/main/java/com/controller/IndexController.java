package com.controller;

import com.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/user")
public class IndexController {

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("控制器");
        return "hello";
    }

    @RequestMapping( "/hellosb")
    public String hellosb(@RequestParam(value = "sb",required = false) String sb){
        System.out.println("hello"+sb);
        return "hello";
    }

    @RequestMapping( "/hello2")
    public String hello2(@RequestParam(value = "name",required = false) String name,Model model){
        User u = new User();
        u.setUsername(name);
        model.addAttribute("user",u);
        return "hello";
    }
}
