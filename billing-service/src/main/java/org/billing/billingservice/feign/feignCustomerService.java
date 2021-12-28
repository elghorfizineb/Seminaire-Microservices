package org.billing.billingservice.feign;

import org.billing.billingservice.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="CUSTOMER-SERVICE")
public interface feignCustomerService {

    @GetMapping(path="/customers/{id}")
    Customer getCustomerById(@PathVariable(name="id") Long id);
}
