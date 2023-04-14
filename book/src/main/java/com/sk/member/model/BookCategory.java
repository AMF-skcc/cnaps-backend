package com.sk.member.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Table(name = "book_category")
@Entity
public class BookCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
}
