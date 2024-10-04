package com.nexsys.crud.client;

import com.nexsys.crud.http.request.ProductRequest;
import com.nexsys.crud.http.response.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Set;

@FeignClient(name = "api-client", url = "${product.service.url}")
public interface IProductClient {

    @GetMapping()
    Set<ProductResponse> findAllCategory();

    @PostMapping
    ProductResponse saveProduct(ProductRequest productRequest);
}

