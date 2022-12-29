package com.graphql.react.LiveWithPlants.repository;

import com.graphql.react.LiveWithPlants.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
