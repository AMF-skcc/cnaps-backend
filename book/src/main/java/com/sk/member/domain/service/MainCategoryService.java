package com.sk.member.domain.service;

import com.sk.member.domain.entity.MainCategory;
import com.sk.member.domain.repository.MainCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainCategoryService {

    @Autowired
    private MainCategoryRepository mainCategoryRepository;

    public MainCategory getMainCategoryById(Long id) {
        return mainCategoryRepository.findById(id).orElse(null);
    }

    public MainCategory createMainCategory(MainCategory mainCategory) {
        return mainCategoryRepository.save(mainCategory);
    }

    public MainCategory updateMainCategory(MainCategory mainCategory) {
        if (mainCategoryRepository.existsById(mainCategory.getId())) {
            return mainCategoryRepository.save(mainCategory);
        } else {
            return null;
        }
    }

    public void deleteMainCategory(Long id) {
        mainCategoryRepository.deleteById(id);
    }

}

