package com.example.ambackenddemo.domain.mdm;

import java.util.List;

public interface CarrierCodeRepository {

    List<CarrierCode> findall();

    CarrierCode save(CarrierCode carrierCode);
}
