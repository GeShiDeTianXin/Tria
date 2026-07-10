package com.tria.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id) {
        System.out.println(111111);
        return "用户id：" + id;
    }

}