package com.example.ambackenddemo.infrastructure.domina.mdm_server.controller;

import java.util.Objects;

record CarrierCodeResponse(
        String carrierCode,
        String icaoCarriercode,
        String carrierCodeName,
        String remark
) {
    CarrierCodeResponse {
        Objects.requireNonNull(carrierCode);
    }
}
