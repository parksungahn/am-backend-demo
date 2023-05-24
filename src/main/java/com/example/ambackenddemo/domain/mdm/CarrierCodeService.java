package com.example.ambackenddemo.domain.mdm;

import java.util.List;

public interface CarrierCodeService {
    List<CarrierCode> retrieves();

    CarrierCode save(CarrierCode carrierCode);
}
