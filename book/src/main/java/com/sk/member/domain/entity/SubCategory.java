package com.sk.member.domain.entity;

import com.sk.member.domain.type.Aggregate;
import com.sk.member.domain.type.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Table(name = "book_category_sub")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class SubCategory implements Entities, Aggregate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String classNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "main_category_id")
    private MainCategory mainCategory;

    public SubCategory(String name, String classNumber, MainCategory mainCategory) {
        this.name = name;
        this.classNumber = classNumber;
        this.mainCategory = mainCategory;
    }
}
