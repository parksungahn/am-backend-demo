package com.example.ambackenddemo.infrastructure.domain.mdm_server.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CarrierCodeJpaRepository extends JpaRepository<CarrierCodeEntity, String> {
}
