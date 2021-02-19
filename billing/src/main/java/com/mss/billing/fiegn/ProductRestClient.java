package com.mss.billing.fiegn;

import com.mss.billing.entities.Customer;
import com.mss.billing.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="PRODUCT-SERVICE")
public interface ProductRestClient {
    @GetMapping(path="/products/{id}")
    Product getProductById(@RequestHeader(value = "Authorization") String jwtToken, @PathVariable(name = "id") Long id);

    @GetMapping(path="/products")
    PagedModel<Product> pageProduct(@RequestHeader(value = "Authorization") String jwtToken,@RequestParam(name = "page")int page,@RequestParam(name = "size")int size);
}
