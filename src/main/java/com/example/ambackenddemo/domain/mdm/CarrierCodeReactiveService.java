package com.example.ambackenddemo.domain.mdm;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CarrierCodeReactiveService {

    Flux<CarrierCode> getCarrierCodes();
    Mono<CarrierCode> createCarrierCode(CarrierCode carrierCode);
//    Mono<CarrierCode> getCarrierCode(CarrierCodeId id);
//    Mono<CarrierCode> updateCarrierCode(CarrierCode carrierCode);
//    Mono<Void> deleteCarrierCode(CarrierCodeId id);
}
