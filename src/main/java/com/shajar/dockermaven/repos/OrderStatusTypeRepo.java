package com.shajar.dockermaven.repos;

import com.shajar.dockermaven.model.OrderStatusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "type",path = "type")
public interface OrderStatusTypeRepo extends JpaRepository<OrderStatusType,Long> {
}
