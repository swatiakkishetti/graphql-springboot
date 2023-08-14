package com.graphql.react.LiveWithPlants.service;

import com.graphql.react.LiveWithPlants.entity.Category;
import com.graphql.react.LiveWithPlants.entity.Product;
import com.graphql.react.LiveWithPlants.repository.CategoryRepository;
import com.graphql.react.LiveWithPlants.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;

    public ProductService(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public Product addProduct(String productName, String description, String imageUrl, BigInteger price){
        Product product = new Product();
        product.setProductName(productName);
        product.setDescription(description);
        product.setImageUrl(imageUrl);
        product.setPrice(price);
        productRepository.save(product);
        return product;
    }

    public Product updateProduct(Long productId, String productName, String description, String imageUrl, BigInteger price){
        Optional<Product> productOptional = productRepository.findById(productId);
        if(!productOptional.isPresent()){
            throw new RuntimeException("Product not found");
        }
        Product product = productOptional.get();
        product.setProductName(productName);
        product.setDescription(description);
        product.setImageUrl(imageUrl);
        product.setPrice(price);
        productRepository.save(product);
        return product;
    }

    public void deleteProduct(Long productId){
        Optional<Product> product = productRepository.findById(productId);
        if(!product.isPresent()){
            throw new RuntimeException("Category not found");
        }
        productRepository.deleteById(productId);
    }

    public List<Product> productByCategoryId(Long categoryId){
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if(!categoryOptional.isPresent()){
            throw new RuntimeException("Category not found");
        }
        List<Product> productList = categoryOptional.get().getListOfProducts();
        return productList;
    }

    public List<Product> productByCategoryName(String categoryName){
        Optional<Category> categoryOptional = categoryRepository.findCategoryByCategoryName(categoryName);
        if(!categoryOptional.isPresent()){
            throw new RuntimeException("Category not found");
        }
        System.out.println(categoryOptional.get().getCategoryId());
        List<Product> productList = categoryOptional.get().getListOfProducts();
        return productList;
    }

    public Product getById(Long productId){
        Optional<Product> productOptional = productRepository.findById(productId);
        if(!productOptional.isPresent()){
            throw new RuntimeException("Category not found");
        }
        return productOptional.get();
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}
