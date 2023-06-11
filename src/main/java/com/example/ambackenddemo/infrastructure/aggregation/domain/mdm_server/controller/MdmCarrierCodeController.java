package com.example.ambackenddemo.infrastructure.aggregation.domain.mdm_server.controller;

import com.example.ambackenddemo.domain.mdm.*;
import com.example.ambackenddemo.infrastructure.domain.mdm_client.utils.MdmHttpUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@RestController
@RequestMapping("/api/v1/carrier_codes")
class MdmCarrierCodeController {
    private final CarrierCodeReactiveService carrierCodeReactiveService;

    MdmCarrierCodeController(final CarrierCodeReactiveService carrierCodeReactiveService) {
        this.carrierCodeReactiveService = Objects.requireNonNull(carrierCodeReactiveService);
    }

    //--SearchAll
    @GetMapping
    Flux<CarrierCodeResponse> getCarrierCodes() {
        return carrierCodeReactiveService.getCarrierCodes().map(MdmHttpUtils::toCarrierCodeResponse);
    }

    //--Save
    @PostMapping
    Mono<CarrierCodeResponse> createCarrierCode(@RequestBody final CarrierCodeRequest requestBody) {
        return carrierCodeReactiveService
                .createCarrierCode(MdmHttpUtils.fromCarrierCodeRequest(requestBody))
                .map(MdmHttpUtils::toCarrierCodeResponse)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.CONFLICT)));
    }

//    @GetMapping("/{code}")
//    Mono<CarrierCodeResponse> getCarrierCode(@PathVariable final String code) {
//        final CarrierCodeId codeId = new CarrierCodeId(code);
//
//        return carrierCodeReactiveService
//                .getCarrierCode(codeId)
//                .map(MdmHttpUtils::toCarrierCodeResponse)
//                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)));
//    }
//
//    @PutMapping("/{code}")
//    Mono<CarrierCodeResponse> updateCarrierCode(
//            @PathVariable final String code,
//            @RequestBody final CarrierCodeRequest requestBody
//    ) {
//        return carrierCodeReactiveService
//                .updateCarrierCode(
//                        new CarrierCode(
//                                new CarrierCodeId(code),
//                                requestBody.icaoCarrierCode(),
//                                requestBody.carrierCodeName(),
//                                requestBody.remark()
//                        ))
//                .map(MdmHttpUtils::toCarrierCodeResponse)
//                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)));
//    }
//
//    @DeleteMapping("/{code}")
//    Mono<Void> deleteCarrierCode(@PathVariable final String code) {
//        return carrierCodeReactiveService.deleteCarrierCode(new CarrierCodeId(code));
//    }


}
