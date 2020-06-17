package com.example.updemo.dto.mapper;

import com.example.updemo.domain.category.Category;
import com.example.updemo.dto.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ProductMapper.class)
public interface CategoryMapper {
    @Mapping(target = "id", source = "category.id")
    @Mapping(target = "name", source = "category.name")
    @Mapping(target = "products", source = "category.products")
    CategoryDto categoryToDto(Category category);

    @Mapping(target = "id", source = "categoryDto.id")
    @Mapping(target = "name", source = "categoryDto.name")
    @Mapping(target = "products", source = "categoryDto.products")
    Category categoryDtoToCategory(CategoryDto categoryDto);
}
