package org.billing.billingservice.repositories;

import org.billing.billingservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface productItemRepository extends JpaRepository<ProductItem,Long> {

    public Collection<ProductItem> findByBillId(Long id);
}
