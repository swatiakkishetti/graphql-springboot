package com.graphql.react.LiveWithPlants.service;

import com.graphql.react.LiveWithPlants.entity.Category;
import com.graphql.react.LiveWithPlants.entity.Product;
import com.graphql.react.LiveWithPlants.repository.CategoryRepository;
import com.graphql.react.LiveWithPlants.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;

    public CategoryService(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public Category addCategory(String categoryName, String description, List<Product> listOfProducts, String imageUrl){
        Category category = new Category();
        category.setCategoryName(categoryName);
        category.setDescription(description);
        category.setListOfProducts(listOfProducts);
        category.setImageUrl(imageUrl);
        categoryRepository.save(category);
        return category;
    }

    public Category updateCategory(Long categoryId, String categoryName, String description, String imageUrl){
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if(!categoryOptional.isPresent()){
            throw new RuntimeException("Category not found");
        }
        Category category = categoryOptional.get();
        category.setCategoryName(categoryName);
        category.setDescription(description);
        category.setImageUrl(imageUrl);
        categoryRepository.save(category);
        return category;
    }

    public void deleteCategory(Long categoryId){
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if(!categoryOptional.isPresent()){
            throw new RuntimeException("Category not found");
        }
        categoryRepository.deleteById(categoryId);
    }

    public Category addProductsToCategory(Long categoryId, List<Long> productIds){
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if(!categoryOptional.isPresent()){
            throw new RuntimeException("Category not found");
        }
        List<Product> productList = categoryOptional.get().getListOfProducts();
        for(Long productId: productIds) {
            Optional<Product> productOptional = productRepository.findById(productId);
            productOptional.ifPresent(productList::add);
        }
        categoryOptional.get().setListOfProducts(productList);
        categoryRepository.save(categoryOptional.get());
        return categoryOptional.get();
    }

    public Category getById(Long categoryId){
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if(!categoryOptional.isPresent()){
            throw new RuntimeException("Category not found");
        }
        return categoryOptional.get();
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
}
