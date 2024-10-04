package com.nexsys.crud.service.implementacion;

import com.nexsys.crud.dto.ProductDTO;
import com.nexsys.crud.dto.ProductRequestDTO;
import com.nexsys.crud.http.request.ProductRequest;
import com.nexsys.crud.http.response.ProductResponse;
import com.nexsys.crud.mapper.ProductMapper;
import com.nexsys.crud.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import static org.springframework.http.HttpMethod.*;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    @Value("${product.service.url}")
    private String productServiceUrl;
    private final RestTemplate restTemplate;
    private final ProductMapper productMapper;


    @Override
    public List<ProductDTO> findAll() {
        return Arrays.stream(Objects.requireNonNull(restTemplate.getForObject(productServiceUrl, ProductResponse[].class)))
                .map(productMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO save(ProductRequestDTO productRequest) {
        HttpEntity<ProductRequest> httpEntity = new HttpEntity<>(converToRequest(productRequest));
        ResponseEntity<ProductRequest> response = restTemplate.exchange(productServiceUrl,POST, httpEntity, ProductRequest.class);
        return ProductDTO.builder()
                .pid(Objects.requireNonNull(response.getBody()).getId())
                .build();
    }

    private ProductRequest converToRequest(ProductRequestDTO productDTO){
        return ProductRequest.builder()
               .title(productDTO.getName())
               .price(productDTO.getPriceFinal())
               .description(productDTO.getDescription())
               .categoryId(Integer.valueOf(productDTO.getCategoryId()))
               .images(Collections.singletonList(productDTO.getImages()))
               .build();
    }
}
