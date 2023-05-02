package com.sk.member.domain.entity;

import com.sk.member.domain.type.AggregateRoot;
import com.sk.member.domain.type.Entities;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Table(name = "book")
@Entity
public class Book implements Entities, AggregateRoot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private BookStatus bookStatus;
    private Integer cntReservation; // 예약 Context와 중복되나, 허용함
    private String author;
    private PublishInfo publishInfo;
    private Long subCategoryId;
    private String categoryName;    // 중복 데이터이나 허용함

    private String translator;
    private String imageUrl;

    private String isbn;
    private String description;
}
