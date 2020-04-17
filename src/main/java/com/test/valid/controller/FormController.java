package com.test.valid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormController {
    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/crear")
    public String getForm() {
        return "form";
    }
}
