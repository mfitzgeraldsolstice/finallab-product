package com.finallab.product.controller;

import com.finallab.product.model.Product;
import com.finallab.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("")
public class ProductController {

    private ProductService productService;

    ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/products")
    public Product save(@RequestBody Product product){
        Product savedProduct = productService.save(product);
        return savedProduct;
    }

    @GetMapping("/{id}")
    public Optional<Product> get(@PathVariable("id") Long id){
        Optional<Product> result = productService.get(id);
        return result;
    }

    @PutMapping("/update")
    public Product update(@RequestBody Product product){
        Product updatedProduct = productService.save(product);
        return updatedProduct;
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Product product){
        productService.delete(product);
    }

}
