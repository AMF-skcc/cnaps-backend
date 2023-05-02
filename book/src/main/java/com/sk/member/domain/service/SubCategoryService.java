package com.sk.member.domain.service;

import com.sk.member.domain.entity.SubCategory;
import com.sk.member.domain.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubCategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    public SubCategory getSubCategoryById(Long id) {
        return subCategoryRepository.findById(id).orElse(null);
    }

    public SubCategory createSubCategory(SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }

    public SubCategory updateSubCategory(SubCategory subCategory) {
        SubCategory existingSubCategory = subCategoryRepository.findById(subCategory.getId()).orElse(null);
        if (existingSubCategory == null) {
            return null;
        } else {
            existingSubCategory.setName(subCategory.getName());
            existingSubCategory.setClassNumber(subCategory.getClassNumber());
            existingSubCategory.setMainCategory(subCategory.getMainCategory());
            return subCategoryRepository.save(existingSubCategory);
        }
    }

    public void deleteSubCategory(Long id) {
        subCategoryRepository.deleteById(id);
    }
}
