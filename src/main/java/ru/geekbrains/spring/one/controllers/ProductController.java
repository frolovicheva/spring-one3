package ru.geekbrains.spring.one.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.one.model.Product;
import ru.geekbrains.spring.one.services.ProductService;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //http://localhost:8189/app
    @GetMapping("/")
    public String showAllProductsPage(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "index";
    }

//    @GetMapping("/products/{id}")
//    public String showProductInfo(@PathVariable(name = "id") Long id, Model model) {
//        productService.findOneById(id).ifPresent(p -> model.addAttribute("product", p));
//        return "product_info";
//    }
    @GetMapping("/products/find/{id}")
    public String showProductInfo1(@RequestParam Long id, Model model) {
        Optional<Product> product = productService.findOneById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
        }
        return "product_info";
    }

    @GetMapping("/products/finder")
    public String showFinder() {
        return "find_product_form";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/";
    }
// !!! Метод не работает. См. также ProductRepository - метод findProductsByCategoryId
    @GetMapping("/products/category/{id}")
    public String findProductsByCategoryId (@PathVariable Long id, Model model) {
        List<Product> products = productService.findProductsByCategoryId (id);
        model.addAttribute("products", products);
        return "redirect:/";
    }
}
