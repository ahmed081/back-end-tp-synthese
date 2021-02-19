package com.mss.billing.fiegn;

import com.mss.billing.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping(path="/customers/{id}")
    Customer getCustomerById(@RequestHeader(value = "Authorization") String jwtToken, @PathVariable(name = "id") Long id);
}
