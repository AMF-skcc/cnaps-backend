package com.sk.member.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookDto {
    private String title;
    private String author;
    private String translator;
    private String imageUrl;
    private Long subCategoryId;
    private String isbn;
    private String publisher;
    private LocalDate publishDate;
    private String description;


//    private String username;
//    private String nickname;
//    private String email;
//    private String role;
//    private String password;
}
