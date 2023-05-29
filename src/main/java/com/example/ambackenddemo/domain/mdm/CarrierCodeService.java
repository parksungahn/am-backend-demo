package com.example.ambackenddemo.domain.mdm;

import java.util.List;
import java.util.Optional;

public interface CarrierCodeService {
    List<CarrierCode> retrieves();
    Optional<CarrierCode> retriveById(CarrierCodeId id);
    CarrierCode save(CarrierCode carrierCode);
    Optional<CarrierCode> update(CarrierCode carrierCode);
    void deleteById(CarrierCodeId id);
}
