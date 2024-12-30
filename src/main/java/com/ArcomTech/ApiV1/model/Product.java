package com.ArcomTech.ApiV1.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product", schema = "public")
public class Product {
    @Column(name = "id")
    private @Id
    @GeneratedValue Integer id;
    @Column(name = "name")
    private String name;
}
