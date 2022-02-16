package com.ethen.order.model;

import lombok.Data;

import java.util.List;

/**
 * @author ethenyang@126.com
 * @since 2022/02/17
 */
@Data
public class OrderInfo {
    private String orderId;
    private List<ProductCount> productCountList;


    @Data
    public static class ProductCount {
        private ProductInfo product;
        private int count;
    }
}
