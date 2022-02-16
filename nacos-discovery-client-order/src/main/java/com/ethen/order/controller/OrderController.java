package com.ethen.order.controller;

import com.ethen.order.model.OrderInfo;
import com.ethen.order.model.OrdersHolder;
import com.ethen.order.model.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ethenyang@126.com
 * @since 2022/02/17
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{id}")
    public Object queryOrderById(@PathVariable("id") String orderId) {
        OrderInfo orderInfo = OrdersHolder.get(orderId);
        String productIds =
                orderInfo.getProductCountList().stream().map(OrderInfo.ProductCount::getProduct).map(ProductInfo::getProductId).collect(Collectors.joining(";"));
        return restTemplate.getForObject("http://inventory-center/product/info/batch-query?productIds=" + productIds,
                List.class);
    }
}
