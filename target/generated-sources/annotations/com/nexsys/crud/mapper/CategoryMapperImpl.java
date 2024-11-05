package com.nexsys.crud.mapper;

import com.nexsys.crud.dto.CategoryDTO;
import com.nexsys.crud.http.response.ProductResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-05T14:39:30-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public List<CategoryDTO> mapToDto(List<ProductResponse> productResponse) {
        if ( productResponse == null ) {
            return null;
        }

        List<CategoryDTO> list = new ArrayList<CategoryDTO>( productResponse.size() );
        for ( ProductResponse productResponse1 : productResponse ) {
            list.add( productResponseToCategoryDTO( productResponse1 ) );
        }

        return list;
    }

    protected CategoryDTO productResponseToCategoryDTO(ProductResponse productResponse) {
        if ( productResponse == null ) {
            return null;
        }

        CategoryDTO.CategoryDTOBuilder categoryDTO = CategoryDTO.builder();

        categoryDTO.title( productResponse.getTitle() );

        return categoryDTO.build();
    }
}
