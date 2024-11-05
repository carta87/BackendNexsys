package com.nexsys.crud.service;

import com.nexsys.crud.dto.ProductDTO;
import com.nexsys.crud.dto.ProductRequestDTO;
import java.util.List;

public interface IProductService {

    /**
     * Metodo para obtener todos los productos.
     * @return lista de productos DTO
     */
    List<ProductDTO> findAll();

    /**
     * Metodo para crear producto
     * @param product objecto
     * @return objecto de product
     */
    ProductDTO save(ProductRequestDTO product);
}
