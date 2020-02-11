package com.geekbrains.septembermarket.controllers;

import com.geekbrains.septembermarket.entities.Product;
import com.geekbrains.septembermarket.repositories.ProductsRepository;
import com.geekbrains.septembermarket.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class ProductRestController {
    private ProductsService productsService;

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("")
    public List<Product> getAllProducts() {
        return productsService.findAll();
    }

    @GetMapping("/{id}") //http://localhost:8189/products/2
   // @ResponseStatus(HttpStatus.OK)
    public Product showProductById(@PathVariable(name = "id") Long id){
        Product product = productsService.findById(id);
        return product;
    }
}