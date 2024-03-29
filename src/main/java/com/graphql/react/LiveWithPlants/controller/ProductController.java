package com.graphql.react.LiveWithPlants.controller;

import com.graphql.react.LiveWithPlants.entity.Product;
import com.graphql.react.LiveWithPlants.service.ProductService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @MutationMapping
    public Product addProduct(@Argument String productName, @Argument String description, @Argument String imageUrl,
                              @Argument BigInteger price){
        return productService.addProduct(productName, description, imageUrl, price);
    }

    @MutationMapping
    public Product updateProduct(@Argument Long productId, @Argument String productName, @Argument String description,
                                 @Argument String imageUrl, @Argument BigInteger price){
        return productService.updateProduct(productId, productName, description, imageUrl, price);
    }

    @MutationMapping
    public void deleteProduct(@Argument Long productId){
        productService.deleteProduct(productId);
    }

    @QueryMapping
    public List<Product> productByCategoryId(@Argument Long categoryId){
        return productService.productByCategoryId(categoryId);
    }

    @QueryMapping
    public List<Product> productByCategoryName(@Argument String categoryName){
        return productService.productByCategoryName(categoryName);
    }

    @QueryMapping
    public Product productById(@Argument Long productId){
        return productService.getById(productId);
    }

    @QueryMapping
    public List<Product> allProducts(){
        return productService.getAllProducts();
    }
}
