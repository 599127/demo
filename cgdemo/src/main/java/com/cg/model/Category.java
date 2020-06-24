package com.cg.model;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Category {
    @Id
    @Column(name= "category_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long categoryId;

    @Column(name= " category_name")
    private String name;

    @Column(name= " category_desc")
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Product> products;

    public Category() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", products=" + products +
                '}';
    }
}
