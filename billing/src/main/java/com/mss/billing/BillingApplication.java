package com.mss.billing;

import com.mss.billing.entities.Bill;
import com.mss.billing.entities.Customer;
import com.mss.billing.entities.Product;
import com.mss.billing.entities.ProductItem;
import com.mss.billing.fiegn.CustomerRestClient;
import com.mss.billing.fiegn.ProductRestClient;
import com.mss.billing.rep.BillRepository;
import com.mss.billing.rep.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.hateoas.PagedModel;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class BillingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingApplication.class, args);
    }
    @Bean
    CommandLineRunner start(RepositoryRestConfiguration restConfiguration) {
        return args -> {
            restConfiguration.exposeIdsFor(Bill.class);
            restConfiguration.exposeIdsFor(ProductItem.class);


        };
    }
}
