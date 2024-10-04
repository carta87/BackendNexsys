package com.nexsys.crud.controller;

import com.nexsys.crud.dto.CategoryDTO;
import com.nexsys.crud.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Set;

@RestController
@RequestMapping("v1/categories/")
@RequiredArgsConstructor
public class CategoryController {

    private final ICategoryService iCategoryService;

    @GetMapping
    public ResponseEntity<Set<CategoryDTO>> findByAllCategory()
    {
        return iCategoryService.findAllCategory().isEmpty()?
                new ResponseEntity<>(HttpStatus.NO_CONTENT):
                new ResponseEntity<>(iCategoryService.findAllCategory(), HttpStatus.OK);
    }
}
