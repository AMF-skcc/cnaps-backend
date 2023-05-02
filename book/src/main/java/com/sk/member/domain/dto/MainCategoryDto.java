package com.sk.member.domain.dto;

import com.sk.member.domain.entity.MainCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MainCategoryDto {

    private Long id;

    private String name;

    private String classNumber; // New field

    public static MainCategoryDto fromModel(MainCategory mainCategory) {
        MainCategoryDto mainCategoryDto = new MainCategoryDto();
        mainCategoryDto.setId(mainCategory.getId());
        mainCategoryDto.setName(mainCategory.getName());
        mainCategoryDto.setClassNumber(mainCategory.getClassNumber()); // Copy
        return mainCategoryDto;
    }

    public MainCategory toModel() {
        MainCategory mainCategory = new MainCategory();
        mainCategory.setId(this.id);
        mainCategory.setName(this.name);
        mainCategory.setClassNumber(this.classNumber); // Copy
        return mainCategory;
    }
}
