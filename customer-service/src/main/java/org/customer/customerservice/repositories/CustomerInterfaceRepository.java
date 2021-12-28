package org.customer.customerservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.customer.customerservice.models.customer;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CustomerInterfaceRepository extends JpaRepository<customer,Long> {
}
