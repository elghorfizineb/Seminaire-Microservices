package org.inventory.inventoryservice.repository;

import org.inventory.inventoryservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface productRepository extends JpaRepository<Product,Long> {
}
