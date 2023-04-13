package com.sk.template.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstController {

    @GetMapping("/api/hello")
    public String hello() {
        return "hello";
    }
}
