package com.finallab.product.service;

import com.finallab.product.summary.OrderLineItemsResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@FeignClient(name="order-service")
public interface OrderLineItemsService {

    @RequestMapping(method = RequestMethod.GET, value="/{id}")
    OrderLineItemsResult getOrderLineItemsById(@PathVariable("id") Long id);

    @PutMapping(value="/update")
    OrderLineItemsResult updateOrderLineItem(@RequestBody OrderLineItemsResult orderLineItemsResult);

    @GetMapping("/orders/product/{productId")
    List<OrderLineItemsResult> getOrderLineItemsByProductId(@PathVariable("productId") Long productId);

}
