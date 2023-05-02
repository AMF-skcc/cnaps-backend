package com.sk.member.controller;

import com.sk.member.domain.dto.SubCategoryDto;
import com.sk.member.domain.entity.SubCategory;
import com.sk.member.domain.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/sub-categories")
public class SubCategoryController {

    @Autowired
    private SubCategoryService subCategoryService;

    @GetMapping("/{id}")
    public ResponseEntity<SubCategoryDto> getSubCategoryById(@PathVariable("id") Long id) {
        SubCategory subCategory = subCategoryService.getSubCategoryById(id);
        if (subCategory == null) {
            return ResponseEntity.notFound().build();
        } else {
            SubCategoryDto subCategoryDto = SubCategoryDto.fromModel(subCategory);
            return ResponseEntity.ok(subCategoryDto);
        }
    }

    @PostMapping
    public ResponseEntity<SubCategoryDto> createSubCategory(@RequestBody SubCategoryDto subCategoryDto) {
        SubCategory subCategory = subCategoryDto.toModel();
        SubCategory createdSubCategory = subCategoryService.createSubCategory(subCategory);
        SubCategoryDto createdSubCategoryDto = SubCategoryDto.fromModel(createdSubCategory);
        return ResponseEntity.created(URI.create("/sub-categories/" + createdSubCategory.getId())).body(createdSubCategoryDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubCategoryDto> updateSubCategory(@PathVariable("id") Long id, @RequestBody SubCategoryDto subCategoryDto) {
        subCategoryDto.setId(id);
        SubCategory subCategory = subCategoryDto.toModel();
        SubCategory updatedSubCategory = subCategoryService.updateSubCategory(subCategory);
        if (updatedSubCategory == null) {
            return ResponseEntity.notFound().build();
        } else {
            SubCategoryDto updatedSubCategoryDto = SubCategoryDto.fromModel(updatedSubCategory);
            return ResponseEntity.ok(updatedSubCategoryDto);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubCategory(@PathVariable("id") Long id) {
        subCategoryService.deleteSubCategory(id);
        return ResponseEntity.noContent().build();
    }
}
