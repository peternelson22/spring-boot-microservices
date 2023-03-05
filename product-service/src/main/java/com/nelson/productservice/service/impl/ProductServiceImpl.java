package com.nelson.productservice.service.impl;

import com.nelson.productservice.repository.ProductRepository;
import com.nelson.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
}
