package com.nexsys.crud.mapper;

import com.nexsys.crud.dto.ProductDTO;
import com.nexsys.crud.http.response.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "id", target = "pid"),
            @Mapping(source = "title", target = "name"),
            @Mapping(source = "price", target = "priceFinal")
    })
    ProductDTO mapToDto(ProductResponse productResponse);
}
