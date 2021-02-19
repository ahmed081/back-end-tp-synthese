package com.mss.productsms;

import com.mss.productsms.entities.Product;
import com.mss.productsms.rep.ProductRepository;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;


@SpringBootApplication
public class ProductsMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductsMsApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration restConfiguration) {
        return args -> {
            restConfiguration.exposeIdsFor(Product.class);
            productRepository.save(new Product(null, "HP 54", 6000, 15));
            productRepository.save(new Product(null, "impremante", 6000, 25));
            productRepository.save(new Product(null, "Smart Phone", 6000, 30));
            productRepository.save(new Product(null, "IPhone", 6000, 12));
            productRepository.findAll().forEach(p -> {
                System.out.println(p.getDescription());
            });

        };
    }
}


