package com.mss.customersms;

import com.mss.customersms.entities.Customer;
import com.mss.customersms.rep.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomersMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomersMsApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration restConfigration){
        return args->{
            restConfigration.exposeIdsFor(Customer.class);
            customerRepository.save(new Customer(null , "ahmed","ahmed@gmail.com"));
            customerRepository.save(new Customer(null , "omar","omar@gmail.com"));
            customerRepository.save(new Customer(null , "khalid","khalid@gmail.com"));

            customerRepository.findAll().forEach(c->{
                System.out.println(c.getFullName());
            });
        };
    }
}
