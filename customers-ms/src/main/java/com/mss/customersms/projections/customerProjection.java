package com.mss.customersms.projections;

import com.mss.customersms.entities.Customer;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullcustomer",types = Customer.class)
public interface customerProjection {
    String getFullName();
}
