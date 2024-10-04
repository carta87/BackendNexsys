package com.nexsys.crud.service;

import com.nexsys.crud.dto.CategoryDTO;
import java.util.Set;

public interface ICategoryService {

    /**
     * Metodo para obtener una lista de categorias
     * @return lista de categorias DTO
     */
    Set<CategoryDTO> findAllCategory();
}
