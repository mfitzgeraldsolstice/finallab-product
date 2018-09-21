package com.finallab.product.controller;

import com.finallab.product.model.Product;
import com.finallab.product.service.ProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("")
public class ProductController {

    Logger logger = LoggerFactory.getLogger("ProductController");


    private ProductService productService;

    ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/products")
    @HystrixCommand(fallbackMethod = "saveProductFallback")
    public Product save(@RequestBody Product product){
        Product savedProduct = productService.save(product);
        return savedProduct;
    }

    @GetMapping("/{id}")
    @HystrixCommand(fallbackMethod = "getProductFallback")
    public Product getProductById(@PathVariable("id") Long id){
        Product result = productService.getProductById(id);
        return result;
    }

    @PutMapping("/update")
    @HystrixCommand(fallbackMethod = "updateProductFallback")
    public Product update(@RequestBody Product product){
        Product updatedProduct = productService.save(product);
        return updatedProduct;
    }

    @DeleteMapping("/delete")
    @HystrixCommand(fallbackMethod = "deleteProductFallback")
    public void delete(@RequestBody Product product){
        productService.delete(product);
    }

    public Product saveProductFallback(Product product){
        logger.error("Error saving product: " + product);
        return new Product();
    }

    public Product getProductFallback(Long id){
        logger.error("Error getting product: " + id);
        return new Product();
    }

    public Product updateProductFallback(Product product){
        logger.error("Error updating product: " + product);
        return new Product();
    }

    public void deleteProductFallback(Product product){
        logger.error("Error deleting product: " + product);
    }
}
