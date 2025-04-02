package com.coding404.myweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    //화면처리
    @GetMapping("/productList")
    public String productList() {
        return "product/productList";
    }

    @GetMapping("/productReg")
    public String productReg() {
        return "product/productReg";
    }
    @GetMapping("/productDetail")
    public String productDetail() {
        return "product/productDetail";
    }
}


