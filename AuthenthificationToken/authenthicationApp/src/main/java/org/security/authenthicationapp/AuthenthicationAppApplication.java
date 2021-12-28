package org.security.authenthicationapp;

import org.security.authenthicationapp.entities.AppRoles;
import org.security.authenthicationapp.entities.AppUser;
import org.security.authenthicationapp.services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class AuthenthicationAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthenthicationAppApplication.class, args);
    }

    @Bean
    CommandLineRunner start(AccountService accountService)
    {
        return args -> {

            //Add ROLES

            accountService.addNewRole(new AppRoles(null,"USER"));
            accountService.addNewRole(new AppRoles(null,"ADMIN"));
            accountService.addNewRole(new AppRoles(null,"CUSTOMER_MANAGER"));
            accountService.addNewRole(new AppRoles(null,"PRODUCT_MANAGER"));
            accountService.addNewRole(new AppRoles(null,"BILLS_MANAGER"));


            //Add USERS

            accountService.addNewUser(new AppUser(null, "user1","1234", new ArrayList<>()));
            accountService.addNewUser(new AppUser(null, "admin","admin", new ArrayList<>()));
            accountService.addNewUser(new AppUser(null, "user2","5678", new ArrayList<>()));
            accountService.addNewUser(new AppUser(null, "user3","abcd", new ArrayList<>()));
            accountService.addNewUser(new AppUser(null, "user4","wxyz", new ArrayList<>()));

            //Add ROLES TO USER

            accountService.addRoleToUser("user1","USER");
            accountService.addRoleToUser("admin","ADMIN");
            accountService.addRoleToUser("admin","USER");
            accountService.addRoleToUser("user2","USER");
            accountService.addRoleToUser("user2","CUSTOMER_MANAGER");
            accountService.addRoleToUser("user3","USER");
            accountService.addRoleToUser("user3","PRODUCT_MANAGER");
            accountService.addRoleToUser("user4","USER");
            accountService.addRoleToUser("user4","BILLS_MANAGER");






        };
    }

}
