package com.nexsys.crud.service.implementacion;

import com.nexsys.crud.client.IProductClient;
import com.nexsys.crud.dto.CategoryDTO;
import com.nexsys.crud.http.response.ProductResponse;
import com.nexsys.crud.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final IProductClient iProductClient;
    private final ModelMapper modelMapper;


    @Override
    public Set<CategoryDTO> findAllCategory() {
        //return iCategoryClient.findAllCategory().stream().map(this::convertToDTO).collect(Collectors.toList());
        return iProductClient.findAllCategory().stream()
                .map(category -> (modelMapper.map(category, CategoryDTO.class)))
                .collect(Collectors.toSet());
    }

    private CategoryDTO convertToDTO(ProductResponse productResponse) {
        return CategoryDTO.builder()
               .cid(productResponse.getId())
               .title(productResponse.getTitle())
               .build();
    }
}
