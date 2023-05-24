package com.example.ambackenddemo.infrastructure.domina.mdm_server.persistence.code;

import com.example.ambackenddemo.domain.mdm.CarrierCodeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarrierCodeRepositoryConfig {
    @Bean
    public CarrierCodeRepository carrierCodeRepository(final CarrierCodeJpaRepository carrierCodeJpaRepository)
    {
        return new CarrierCodeSpringDatarRepository((carrierCodeJpaRepository));
    }
}
