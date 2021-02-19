package com.mss.billing.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Date billingDate;
    @OneToMany(mappedBy="bill")
    private Collection<ProductItem> productItems;
    private long customerId;
    @Transient
    Customer costumer;

}
