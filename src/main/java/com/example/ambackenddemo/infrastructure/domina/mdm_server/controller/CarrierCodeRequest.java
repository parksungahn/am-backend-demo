package com.example.ambackenddemo.infrastructure.domina.mdm_server.controller;

import java.util.Objects;

record CarrierCodeRequest(String carrierCode,
                          String icaoCarrierCode,
                          String carrierCodeName,
                          String remark

) {
    CarrierCodeRequest{
        Objects.requireNonNull(carrierCode);
    }
}
