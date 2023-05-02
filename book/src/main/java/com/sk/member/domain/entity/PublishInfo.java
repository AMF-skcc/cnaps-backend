package com.sk.member.domain.entity;

import com.sk.member.domain.type.ValueObject;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Embeddable
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PublishInfo implements ValueObject {
    private String publisher;
    private LocalDate publishDate;
}
