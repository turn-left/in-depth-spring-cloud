package com.ethen.inventory.controller;

import com.ethen.inventory.model.ProductInfo;
import com.ethen.inventory.model.ProductsHolder;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ethenyang@126.com
 * @since 2022/02/16
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @RequestMapping("/info/batch-query")
    public Object batchQuery(@RequestParam String productIds) {
        Assert.hasLength(productIds, "invalid productId");
        String[] pIdArray = productIds.split(";");
        List<ProductInfo> productList = new ArrayList<>();
        for (String pId : pIdArray) {
            productList.add(ProductsHolder.get(pId));
        }
        return productList;
    }
}
