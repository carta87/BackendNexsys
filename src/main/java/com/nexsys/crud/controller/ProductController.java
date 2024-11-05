package com.nexsys.crud.controller;

import com.nexsys.crud.dto.ProductDTO;
import com.nexsys.crud.dto.ProductRequestDTO;
import com.nexsys.crud.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("v1/products/")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService iProductService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll(){
        return iProductService.findAll().isEmpty()?
                new ResponseEntity<>(HttpStatus.NO_CONTENT):
                new ResponseEntity<>(iProductService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductRequestDTO product) {
        return new ResponseEntity<>(iProductService.save(product), HttpStatus.CREATED);
    }
}
