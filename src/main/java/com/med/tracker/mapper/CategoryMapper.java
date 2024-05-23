package com.med.tracker.mapper;

import com.med.tracker.dto.CategoryDTO;
import com.med.tracker.entity.Category;

public class CategoryMapper {

    // Map CategoryDTO to Category Entity
    public static Category categoryDtoToEntity(CategoryDTO categoryDTO){
        return new Category(
                categoryDTO.id(),
                categoryDTO.name()

        );
    }

    public static CategoryDTO categoryEntityToDto(Category category){
        return new CategoryDTO(
                category.getId(),
                category.getName()

        );
    }
}
