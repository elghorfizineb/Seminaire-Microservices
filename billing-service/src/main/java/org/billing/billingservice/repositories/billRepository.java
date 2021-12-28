package org.billing.billingservice.repositories;

import org.billing.billingservice.entities.bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface billRepository extends JpaRepository<bill,Long> {
}
