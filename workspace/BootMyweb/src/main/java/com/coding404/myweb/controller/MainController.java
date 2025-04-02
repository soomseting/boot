package com.coding404.myweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    //메인화면 띄울 용도로 만드는 MainController

    @GetMapping("/main")
    public String main() {
        return "main";
    }





}
