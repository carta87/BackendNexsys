package com.nexsys.crud.config;

import com.nexsys.crud.dto.CategoryDTO;
import com.nexsys.crud.http.response.ProductResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addMappings(new PropertyMap<ProductResponse, CategoryDTO>() {
            @Override
            protected void configure() {
                //Aquí agregar el mapeo para los atributos con nombres muy diferentes
                map().setCid(source.getCategory().getId());
                map().setTitle(source.getCategory().getName());
            }
        });

        return modelMapper;
    }
}