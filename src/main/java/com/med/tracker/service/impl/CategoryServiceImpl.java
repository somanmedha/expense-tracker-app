package com.med.tracker.service.impl;

import com.med.tracker.dto.CategoryDTO;
import com.med.tracker.entity.Category;
import com.med.tracker.exception.CategoryException;
import com.med.tracker.mapper.CategoryMapper;
import com.med.tracker.repository.CategoryRepository;
import com.med.tracker.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {


    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category= CategoryMapper.categoryDtoToEntity(categoryDTO);
        Category savedCategory= categoryRepository.save(category);
        return CategoryMapper.categoryEntityToDto(savedCategory);


    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
       Category category= categoryRepository.findById(id).orElseThrow(()-> new CategoryException("Category not found with id:"+id));
       return CategoryMapper.categoryEntityToDto(category);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
       return categoryRepository.findAll().stream()
                .map(CategoryMapper::categoryEntityToDto)
               .sorted(Comparator.comparing(CategoryDTO::id))
                .toList();

    }

    @Override
    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {

       Category category= categoryRepository.findById(id).orElseThrow(()->new CategoryException("Category not found with id:"+id));
       category.setName(categoryDTO.name());
       Category updatedCategory= categoryRepository.save(category);
        return CategoryMapper.categoryEntityToDto(updatedCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category= categoryRepository.findById(id).orElseThrow(()->new CategoryException("Category not found with id:"+id));
        categoryRepository.deleteById(category.getId());
    }
}
