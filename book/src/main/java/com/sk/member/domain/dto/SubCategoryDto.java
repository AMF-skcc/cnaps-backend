package com.sk.member.domain.dto;

import com.sk.member.domain.entity.SubCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubCategoryDto {
    private Long id;

    private String name;

    private String classNumber;

    private MainCategoryDto mainCategory; // New field

    public static SubCategoryDto fromModel(SubCategory subCategory) {
        SubCategoryDto subCategoryDto = new SubCategoryDto();
        subCategoryDto.setId(subCategory.getId());
        subCategoryDto.setName(subCategory.getName());
        subCategoryDto.setClassNumber(subCategory.getClassNumber());
        subCategoryDto.setMainCategory(MainCategoryDto.fromModel(subCategory.getMainCategory())); // Copy
        return subCategoryDto;
    }

    public SubCategory toModel() {
        SubCategory subCategory = new SubCategory();
        subCategory.setId(this.id);
        subCategory.setName(this.name);
        subCategory.setClassNumber(this.classNumber);
        subCategory.setMainCategory(this.mainCategory.toModel()); // Copy
        return subCategory;
    }
}
