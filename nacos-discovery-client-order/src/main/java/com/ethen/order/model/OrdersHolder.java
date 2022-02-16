package com.ethen.order.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ethenyang@126.com
 * @since 2022/02/17
 */
public class OrdersHolder {
    static final Map<String, OrderInfo> CACHE = new ConcurrentHashMap<>();

    static {

    }

    public static OrderInfo get(String orderId) {
        return CACHE.get(orderId);
    }
}
