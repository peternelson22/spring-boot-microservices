package com.nelson.productservice.service;

import com.nelson.productservice.dto.ProductRequest;
import com.nelson.productservice.dto.ProductResponse;

public interface ProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getProduct(long productId);
}
