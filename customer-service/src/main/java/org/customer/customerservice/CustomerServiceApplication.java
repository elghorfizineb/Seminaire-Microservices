package org.customer.customerservice;

import org.customer.customerservice.models.customer;
import org.customer.customerservice.repositories.CustomerInterfaceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerInterfaceRepository customerRepo, RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(customer.class);
        return args->{

            customerRepo.save(new customer(null,"Zineb","elghorfi@gmail.com"));
            customerRepo.save(new customer(null,"Anas","benrkia@gmail.com"));
            customerRepo.save(new customer(null,"Ayoub","blackangel@gmail.com"));
            customerRepo.findAll().forEach(c -> {
                System.out.println(c.toString());

            });

        };

    }

}
