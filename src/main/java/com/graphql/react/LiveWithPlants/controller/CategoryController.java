package com.graphql.react.LiveWithPlants.controller;

import com.graphql.react.LiveWithPlants.entity.Category;
import com.graphql.react.LiveWithPlants.entity.Product;
import com.graphql.react.LiveWithPlants.service.CategoryService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @MutationMapping
    public Category addCategory(@Argument String categoryName, @Argument String description,
                                @Argument List<Product> listOfProducts, @Argument String imageUrl){
        return categoryService.addCategory(categoryName, description, listOfProducts, imageUrl);
    }

    @MutationMapping
    public Category updateCategory(@Argument Long categoryId,@Argument String categoryName,@Argument String description,
                                   @Argument String imageUrl){
        return categoryService.updateCategory(categoryId, categoryName, description, imageUrl);
    }

    @MutationMapping
    public void deleteCategory(@Argument Long categoryId){
        categoryService.deleteCategory(categoryId);
    }

    @MutationMapping
    public Category addProductsToCategory(@Argument Long categoryId, @Argument List<Long> productId){
        return categoryService.addProductsToCategory(categoryId, productId);
    }

    @QueryMapping
    public Category categoryById(@Argument Long categoryId){
        return categoryService.getById(categoryId);
    }

    @QueryMapping
    public List<Category> allCategories(){
        return categoryService.getAllCategories();
    }
}
