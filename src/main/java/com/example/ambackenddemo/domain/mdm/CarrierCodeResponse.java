package com.example.ambackenddemo.domain.mdm;

import java.util.Objects;

public record CarrierCodeResponse(
        String carrierCode,
        String icaoCarriercode,
        String carrierCodeName,
        String remark
) {
    public CarrierCodeResponse {
        Objects.requireNonNull(carrierCode);
    }
}
