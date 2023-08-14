package com.graphql.react.LiveWithPlants.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long productId;
    private String productName;
    private String description;
    private String imageUrl;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private BigInteger price;
}
