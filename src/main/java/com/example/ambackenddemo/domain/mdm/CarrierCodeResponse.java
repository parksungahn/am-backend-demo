package com.example.ambackenddemo.domain.mdm;

import java.util.Objects;

public record CarrierCodeResponse(
        String carrierCode,
        String icaoCarrierCode,
        String carrierCodeName,
        String remark
) {
    public CarrierCodeResponse {
        Objects.requireNonNull(carrierCode);
    }
}
