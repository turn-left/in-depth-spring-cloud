package com.ethen.order.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author ethenyang@126.com
 * @since 2022/02/16
 */
@Data
@Builder
public class ProductInfo {
    private String productId;
    private String name;
    private String brand;
    private String model;
    private String type;
    private double price;
}
