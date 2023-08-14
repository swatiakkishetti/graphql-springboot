package com.graphql.react.LiveWithPlants.repository;

import com.graphql.react.LiveWithPlants.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findCategoryByCategoryName(String categoryName);
}
