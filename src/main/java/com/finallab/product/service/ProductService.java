package com.finallab.product.service;

import com.finallab.product.model.Product;
import com.finallab.product.repository.ProductRepository;
import com.finallab.product.summary.OrderLineItemsResult;
//import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    ProductRepository productRepository;
    OrderLineItemsService orderLineItemsService;

    public ProductService(ProductRepository productRepository, OrderLineItemsService orderLineItemsService){
        this.productRepository = productRepository;
        this.orderLineItemsService = orderLineItemsService;
    }

    public Product save(Product product){
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    public Product getProductById(Long id){
        Product result = productRepository.getProductById(id);
        return result;
    }

    public void delete(Product product){
       List<OrderLineItemsResult> results = orderLineItemsService.getOrderLineItemsByProductId(product.getId());
        for(int i = 0; i < results.size(); i++){
            results.get(i).setProduct(null);
            orderLineItemsService.updateOrderLineItem(results.get(i));
        }
        productRepository.delete(product);
    }

}
