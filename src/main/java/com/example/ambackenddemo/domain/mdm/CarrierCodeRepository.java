package com.example.ambackenddemo.domain.mdm;

import java.util.List;
import java.util.Optional;

public interface CarrierCodeRepository {

    List<CarrierCode> findAll();

    Optional<CarrierCode> findById(CarrierCodeId id);

    CarrierCode save(CarrierCode carrierCode);

    Optional<CarrierCode> update(CarrierCode carrierCode);

    void deleteById(CarrierCodeId id);
}
