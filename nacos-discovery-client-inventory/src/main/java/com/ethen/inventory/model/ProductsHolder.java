package com.ethen.inventory.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ethenyang@126.com
 * @since 2022/02/16
 */
public class ProductsHolder {
    static Map<String, ProductInfo> CACHE = new ConcurrentHashMap<>();

    static {
        ProductInfo mix5 =
                ProductInfo.builder().productId("01").brand("小米").name("小米 MIX5").price(4800).type("手机").model("MIX5").build();
        ProductInfo model3 =
                ProductInfo.builder().productId("02").brand("特斯拉").name("特斯拉 model3").price(290000).type("汽车").model(
                        "model3").build();
        ProductInfo greeX =
                ProductInfo.builder().productId("03").brand("格力").name("格力空调 X").price(2600).type("空调").model("X").build();
        CACHE.put("prod" + mix5.getProductId(), mix5);
        CACHE.put("prod" + model3.getProductId(), model3);
        CACHE.put("prod" + greeX.getProductId(), greeX);
    }

    public static ProductInfo get(String productId) {
        return CACHE.get(productId);
    }
}
