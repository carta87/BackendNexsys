package com.nexsys.crud.mapper;

import com.nexsys.crud.dto.CategoryDTO;
import com.nexsys.crud.http.response.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mapping(source = "category.id", target = "cid")
    @Mapping(source = "category.name", target = "title")
    List<CategoryDTO> mapToDto(List<ProductResponse> productResponse);

}
