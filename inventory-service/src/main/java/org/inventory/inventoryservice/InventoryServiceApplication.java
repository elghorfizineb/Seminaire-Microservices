package org.inventory.inventoryservice;


import org.inventory.inventoryservice.models.Product;
import org.inventory.inventoryservice.repository.productRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(productRepository product , RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Product.class);
        return args -> {
            product.save(new Product(null,"Pommes",10,4.5));
            product.save(new Product(null,"Fraises",100,10));
            product.save(new Product(null,"Ananas",50,40.3));

            product.findAll().forEach(p -> {
                System.out.println(p.toString());
            });
        };
    }

}
