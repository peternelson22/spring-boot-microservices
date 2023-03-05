package com.nelson.productservice.service.impl;

import com.nelson.productservice.dto.ProductRequest;
import com.nelson.productservice.dto.ProductResponse;
import com.nelson.productservice.entity.Product;
import com.nelson.productservice.exception.ResourceNotFoundException;
import com.nelson.productservice.repository.ProductRepository;
import com.nelson.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("Adding product...");
        Product product = Product.builder()
                .productName(productRequest.getName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();
        productRepository.save(product);

        log.info("Product created");
        return product.getProductId();
    }

    @Override
    public ProductResponse getProduct(long productId) {
        log.info("Getting product with id {}", productId);
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product does not exist", "PRODUCT_NOT_FOUND"));

        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(product, productResponse);
        return productResponse;
    }
}
