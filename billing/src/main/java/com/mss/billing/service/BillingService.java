package com.mss.billing.service;

import com.mss.billing.entities.Bill;
import com.mss.billing.entities.Customer;
import com.mss.billing.fiegn.CustomerRestClient;
import com.mss.billing.fiegn.ProductRestClient;
import com.mss.billing.rep.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

@RestController
public class BillingService {
    final
    BillRepository billRepository;
    final
    CustomerRestClient customerRestClient;
    final
    ProductRestClient productRestClient;

    public BillingService(BillRepository billRepository, CustomerRestClient customerRestClient,ProductRestClient productRestClient) {
        this.billRepository = billRepository;
        this.customerRestClient = customerRestClient;
        this.productRestClient = productRestClient;
    }

    @GetMapping(path = "/fullbills")
    public Collection<Bill> getBills (HttpServletRequest request){
        List<Bill> billList = billRepository.findAll();
        billList.forEach(bill -> {
            Customer c = customerRestClient.getCustomerById(request.getHeader("Authorization"),bill.getCustomerId());
            bill.setCostumer(c);
        });
        return billList;
    }
    @GetMapping(path = "/fullbills/{id}")
    public Bill getBill (HttpServletRequest request, @PathVariable(name = "id")  Long id){
        Bill bill = billRepository.findById(id).get();
        Customer c = customerRestClient.getCustomerById(request.getHeader("Authorization"),bill.getCustomerId());
        bill.setCostumer(c);
        bill.getProductItems().forEach(pi ->{
            pi.setProduct(productRestClient.getProductById(request.getHeader("Authorization"),pi.getId()));
        });
        return bill;
    }
}
