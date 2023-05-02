package com.sk.member.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Data
@Table(name = "book_category_main")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class MainCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String classNumber;

    @OneToMany(mappedBy = "mainCategory", cascade = CascadeType.ALL)
    private Set<SubCategory> subCategories = new HashSet<>();

    public MainCategory(String name, String classNumber) {
        this.name = name;
        this.classNumber = classNumber;
    }

    // factory method to create a new instance of main category
    public static MainCategory createMainCategory(String name, String classNumber) {
        return new MainCategory(name, classNumber);
    }

    public void addSubCategory(SubCategory subCategory) {
        subCategories.add(subCategory);
        subCategory.setMainCategory(this);
    }

    public void removeSubCategory(SubCategory subCategory) {
        subCategories.remove(subCategory);
        subCategory.setMainCategory(null);
    }

    public void changeName(String name) {
        if (this.id == null) {
            throw new RuntimeException("You can't change unidentified category's name.");
        }
        this.name = name;
    }
    public void changeClassNumber(String classNumber) {
        if (this.id == null) {
            throw new RuntimeException("You can't change unidentified category's classification number.");
        }
        this.classNumber = classNumber;
    }
    
    // add sum function for three numbers
    

}
