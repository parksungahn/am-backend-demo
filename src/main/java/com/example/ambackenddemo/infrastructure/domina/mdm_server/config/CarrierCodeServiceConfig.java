package com.example.ambackenddemo.infrastructure.domina.mdm_server.config;

import com.example.ambackenddemo.domain.mdm.CarrierCodeRepository;
import com.example.ambackenddemo.domain.mdm.CarrierCodeService;
import com.example.ambackenddemo.domain.mdm.CarrierCodeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarrierCodeServiceConfig {
    @Bean
    public CarrierCodeService carrierCodeService(final CarrierCodeRepository carrierCodeRepository)
    {
        return new CarrierCodeServiceImpl(carrierCodeRepository);
    }
}
