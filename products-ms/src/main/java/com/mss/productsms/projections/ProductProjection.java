package com.mss.productsms.projections;

import com.mss.productsms.entities.Product;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullproduct",types = Product.class)
public interface ProductProjection {
    public String getDescription();

}
