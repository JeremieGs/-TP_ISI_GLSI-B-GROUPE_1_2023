package com.ega.Ega.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Pagecontroller {
    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/compte")
    public String compte() {
        return "compte";
    }
    @GetMapping("/operation")
    public String operation() {
        return "operation";
    }
    @GetMapping("/virement")
    public String virement() {
        return "virement";
    }
}
