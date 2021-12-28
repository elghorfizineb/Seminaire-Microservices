package org.billing.billingservice;

import org.billing.billingservice.entities.ProductItem;
import org.billing.billingservice.entities.bill;
import org.billing.billingservice.feign.ProductItemService;
import org.billing.billingservice.feign.feignCustomerService;
import org.billing.billingservice.models.Customer;
import org.billing.billingservice.models.Product;
import org.billing.billingservice.repositories.billRepository;
import org.billing.billingservice.repositories.productItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(billRepository billrepo,
                            productItemRepository prItrepo,
                            feignCustomerService feignCustomerService,
                            ProductItemService productItemService){
        return args -> {

            Customer customer = feignCustomerService.getCustomerById(1L);
            bill Bill = billrepo.save(new bill(null, new Date(), null, customer.getId(),null));
            /*System.out.println("----------------------------------------------");
            System.out.println(customer.getId());
            System.out.println(customer.getName());
            System.out.println(customer.getEmail()); */

            PagedModel<Product> pagedModel = productItemService.pageProducts();
            pagedModel.forEach(p -> {
                ProductItem productItem = new ProductItem();
                productItem.setPrice(p.getPrice());
                productItem.setQuantity(1+new Random().nextInt(100));
                productItem.setBill(Bill);
                prItrepo.save(productItem);

            });



        };
    }

}
