package com.tria.admin.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class LoginController {

    @PostMapping("/login")
    public String getUser(@RequestBody Long id) {
        System.out.println(111111);
        return "用户id：" + id;
    }

}