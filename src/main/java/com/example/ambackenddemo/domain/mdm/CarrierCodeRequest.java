package com.example.ambackenddemo.domain.mdm;

import java.util.Objects;

public record CarrierCodeRequest(String carrierCode,
                          String icaoCarrierCode,
                          String carrierCodeName,
                          String remark

) {
    public CarrierCodeRequest{
        Objects.requireNonNull(carrierCode);
    }
}
