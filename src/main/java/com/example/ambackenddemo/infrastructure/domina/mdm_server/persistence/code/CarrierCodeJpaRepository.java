package com.example.ambackenddemo.infrastructure.domina.mdm_server.persistence.code;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrierCodeJpaRepository extends JpaRepository<CarrierCodeEntity, String> {
}
