package com.example.ambackenddemo.infrastructure.domain.mdm_server.persistence;

import com.example.ambackenddemo.domain.mdm.CarrierCodeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class CarrierCodeRepositoryConfig {
    @Bean
    public CarrierCodeRepository carrierCodeRepository(final CarrierCodeJpaRepository carrierCodeJpaRepository)
    {
        return new CarrierCodeSpringDataRepository(carrierCodeJpaRepository);
    }
}
