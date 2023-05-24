package com.example.ambackenddemo.domain.mdm;

public record CarrierCode(
        CarrierCodeId carrierCode,
        String icaoCarrierCode,
        String carrierCodeName,
        String remark
) {
}
