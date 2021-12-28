package org.billing.billingservice.web;

import org.billing.billingservice.entities.bill;
import org.billing.billingservice.feign.ProductItemService;
import org.billing.billingservice.feign.feignCustomerService;
import org.billing.billingservice.models.Customer;
import org.billing.billingservice.models.Product;
import org.billing.billingservice.repositories.billRepository;
import org.billing.billingservice.repositories.productItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Path;

@RestController
public class billingRestController {

    private billRepository billRepository;
    private productItemRepository productItemRepository;
    private feignCustomerService customerService;
    private ProductItemService productItemService;

    public billingRestController(org.billing.billingservice.repositories.billRepository billRepository, org.billing.billingservice.repositories.productItemRepository productItemRepository, feignCustomerService customerService, ProductItemService productItemService) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.customerService = customerService;
        this.productItemService = productItemService;
    }

    @GetMapping(path="/fullbill/{id}")
    public bill getBill(@PathVariable(name="id") Long id){
        bill Bill = billRepository.findById(id).get();
        Customer customer = customerService.getCustomerById(Bill.getCustomerId());
        Bill.setCustomer(customer);
        Bill.getProductItems().forEach(pi ->{
            Product product = productItemService.getProductByID(pi.getProductId());
            pi.setProduct(product);

        });
        return Bill;

    }
}
