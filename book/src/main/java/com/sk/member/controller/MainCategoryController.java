package com.sk.member.controller;

import com.sk.member.domain.dto.MainCategoryDto;
import com.sk.member.domain.entity.MainCategory;
import com.sk.member.domain.service.MainCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/main-categories")
public class MainCategoryController {

    @Autowired
    private MainCategoryService mainCategoryService;

    @GetMapping("/{id}")
    public ResponseEntity<MainCategoryDto> getMainCategoryById(@PathVariable("id") Long id) {
        MainCategory mainCategory = mainCategoryService.getMainCategoryById(id);
        if (mainCategory == null) {
            return ResponseEntity.notFound().build();
        } else {
            MainCategoryDto mainCategoryDto = MainCategoryDto.fromModel(mainCategory);
            return ResponseEntity.ok(mainCategoryDto);
        }
    }

    @PostMapping
    public ResponseEntity<MainCategoryDto> createMainCategory(@RequestBody MainCategoryDto mainCategoryDto) {
        MainCategory mainCategory = mainCategoryDto.toModel();
        MainCategory createdMainCategory = mainCategoryService.createMainCategory(mainCategory);
        MainCategoryDto createdMainCategoryDto = MainCategoryDto.fromModel(createdMainCategory);
        return ResponseEntity.created(URI.create("/main-categories/" + createdMainCategory.getId())).body(createdMainCategoryDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MainCategoryDto> updateMainCategory(@PathVariable("id") Long id, @RequestBody MainCategoryDto mainCategoryDto) {
        mainCategoryDto.setId(id);
        MainCategory mainCategory = mainCategoryDto.toModel();
        MainCategory updatedMainCategory = mainCategoryService.updateMainCategory(mainCategory);
        if (updatedMainCategory == null) {
            return ResponseEntity.notFound().build();
        } else {
            MainCategoryDto updatedMainCategoryDto = MainCategoryDto.fromModel(updatedMainCategory);
            return ResponseEntity.ok(updatedMainCategoryDto);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMainCategory(@PathVariable("id") Long id) {
        mainCategoryService.deleteMainCategory(id);
        return ResponseEntity.noContent().build();
    }
}
