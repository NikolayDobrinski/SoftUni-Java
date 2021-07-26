package com.example.xmlexercise.service;

import com.example.xmlexercise.model.dtos.ProductSeedDto;
import com.example.xmlexercise.model.dtos.ProductViewRootDto;

import java.util.List;

public interface ProductService {
    long getCount();

    void seedProducts(List<ProductSeedDto> products);

    ProductViewRootDto findProductsInRangeWithoutBuyer();

}
