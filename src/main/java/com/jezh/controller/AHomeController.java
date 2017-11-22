package com.jezh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AHomeController {

    @RequestMapping("/")
    public String homePage() {
        return "home";
    }
}
