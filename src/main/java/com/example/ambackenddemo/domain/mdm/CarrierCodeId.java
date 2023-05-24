package com.example.ambackenddemo.domain.mdm;

import java.util.Objects;

public record CarrierCodeId(
        String value
) {
    public CarrierCodeId{
        Objects.requireNonNull(value);
    }
}
