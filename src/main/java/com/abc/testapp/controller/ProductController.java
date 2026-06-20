package com.abc.testapp.controller;


import com.abc.testapp.entity.Product;
import com.abc.testapp.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(
            ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String listProducts(Model model) {

        model.addAttribute(
                "products",
                productService.getAll());

        return "products";
    }
    @GetMapping("/new")
    public String showAddForm(Model model) {

        model.addAttribute(
                "product",
                new Product());

        return "product-form";
    }

    @PostMapping("/save")
    public String saveProduct(
            @ModelAttribute Product product) {

        productService.save(product);

        return "redirect:/products";
    }
    
    @GetMapping("/edit/{id}")
    public String editProduct(
            @PathVariable Long id,
            Model model) {

        Product product =
                productService.getById(id);

        model.addAttribute(
                "product",
                product);

        return "product-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(
            @PathVariable Long id) {

        productService.delete(id);

        return "redirect:/products";
    }
}