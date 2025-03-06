package com.example.demo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.domain.Product;

@Controller
public class ProductController {
    @GetMapping("admin/product")
    public String getProductPage(Model model) {
        return "admin/product/detail";
    }

    @GetMapping("admin/product/create")
    public String getCreateProduct(Model model) {
        model.addAttribute("newProduct", new Product());
        return "admin/product/create";
    }
}
