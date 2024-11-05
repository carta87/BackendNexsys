package com.nexsys.crud.mapper;

import com.nexsys.crud.dto.ProductDTO;
import com.nexsys.crud.http.response.ProductResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-05T13:38:48-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO mapToDto(ProductResponse productResponse) {
        if ( productResponse == null ) {
            return null;
        }

        ProductDTO.ProductDTOBuilder productDTO = ProductDTO.builder();

        productDTO.pid( productResponse.getId() );
        productDTO.name( productResponse.getTitle() );
        productDTO.priceFinal( productResponse.getPrice() );
        productDTO.description( productResponse.getDescription() );

        return productDTO.build();
    }
}
