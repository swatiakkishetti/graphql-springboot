package com.graphql.react.LiveWithPlants.repository;

import com.graphql.react.LiveWithPlants.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
