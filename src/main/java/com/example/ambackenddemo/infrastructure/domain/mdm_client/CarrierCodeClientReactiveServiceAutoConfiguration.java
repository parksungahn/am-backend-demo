package com.example.ambackenddemo.infrastructure.domain.mdm_client;

import com.example.ambackenddemo.domain.mdm.CarrierCodeReactiveService;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@AutoConfigureAfter(WebClientAutoConfiguration.class)
@EnableConfigurationProperties(MdmClientProperties.class)
class CarrierCodeClientReactiveServiceAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnBean(WebClient.Builder.class)
    CarrierCodeReactiveService carrierCodeReactiveService(
            final WebClient.Builder builder,
            final MdmClientProperties properties
    ) {
        return new CarrierCodeClientReactiveService(
                builder.baseUrl(properties.baseUrl()).build()
        );
    }
}
