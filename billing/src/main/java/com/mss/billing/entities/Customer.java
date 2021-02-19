package com.mss.billing.entities;

import lombok.Data;

@Data
public class Customer {
    Long id;
    String fullName;
    String email;
}
