package com.example.jpa.controller;


import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JPAController {

    //단순히 화면만 띄움
    @GetMapping("/memoFind")
    public String memoFind() {
        return "memoFind";
    }

}
