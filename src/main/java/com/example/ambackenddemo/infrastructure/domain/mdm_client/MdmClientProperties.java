package com.example.ambackenddemo.infrastructure.domain.mdm_client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.Objects;

@ConfigurationProperties(prefix = "winloads.domain.mdm.client")
record MdmClientProperties(
        @DefaultValue("http://localhost:9093") String baseUrl
) {
    public MdmClientProperties {
        Objects.requireNonNull(baseUrl);
    }
}
