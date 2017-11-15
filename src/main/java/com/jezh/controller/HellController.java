package com.jezh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hell")
public class HellController {

    @RequestMapping("processForm")
    public String procF(@RequestParam("name") String name, @ModelAttribute("dude") String dude, Model model) {
        return "hello";
    }
    @RequestMapping("showForm")
    public String showF() {
        return "hello-form";
    }
}
