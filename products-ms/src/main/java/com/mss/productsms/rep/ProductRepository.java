package com.mss.productsms.rep;

import com.mss.productsms.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product,Long> {
}