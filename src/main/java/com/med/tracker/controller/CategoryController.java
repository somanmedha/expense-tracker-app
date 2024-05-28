package com.med.tracker.controller;


import com.med.tracker.dto.CategoryDTO;
import com.med.tracker.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for Category",
        description = "CRUD REST APIs for Category- Create Category" + "Update Category, Get Category and Delete Category"
)
@RestController
@RequestMapping("/api/categories")
public class CategoryController {


    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Operation(
            summary = "Create Category REST API",
            description = "Create Category REST API to save category into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP STATUS 201 CREATED"
    )
    //Create category REST API
    @PostMapping("/create-category")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        CategoryDTO category = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @Operation(
            summary = "GET Category REST API",
            description = "GET Category REST API to get category from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )


    @GetMapping("/{id}")
    ResponseEntity<CategoryDTO> getCategoryById(@PathVariable("id") Long categoryId) {
        CategoryDTO categoryDTO = categoryService.getCategoryById(categoryId);
        return ResponseEntity.ok(categoryDTO);
    }

    @Operation(
            summary = "GET Category List REST API",
            description = "GET Category REST API to get list of all categories from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )

    @GetMapping
    ResponseEntity<List<CategoryDTO>> fetchAllCategories() {
        List<CategoryDTO> categoryDTOList = categoryService.getAllCategories();
        return ResponseEntity.ok(categoryDTOList);
    }

    @Operation(
            summary = "Update Category REST API",
            description = "Update Category REST API to update category in database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )

    @PutMapping("update/{id}")
    ResponseEntity<CategoryDTO> updateCategory(@PathVariable("id") Long categoryId, @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO updatedCategory = categoryService.updateCategory(categoryId, categoryDTO);
        return ResponseEntity.ok(updatedCategory);

    }

    @Operation(
            summary = "Delete Category REST API",
            description = "Delete Category REST API to delete category from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteCategoryById(@PathVariable("id") Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok("Category deleted successfully!");
    }
}
