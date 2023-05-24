package com.example.ambackenddemo.infrastructure.domina.mdm_server.controller;

import com.example.ambackenddemo.domain.mdm.CarrierCode;
import com.example.ambackenddemo.domain.mdm.CarrierCodeId;
import com.example.ambackenddemo.domain.mdm.CarrierCodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/carrier_code")
public class CarrierCodeController {
    private final CarrierCodeService carrierCodeService;

    CarrierCodeController(CarrierCodeService carrierCodeService)
    {
        this.carrierCodeService = carrierCodeService;
    }

    //--전체조회 - http://localhost:8081/carrier_code
    @GetMapping
    ResponseEntity<List<CarrierCodeResponse>> retrieves2() {
        return ResponseEntity.ok(carrierCodeService.retrieves()
                .stream()
                .map(CarrierCodeController::toResponse)
                .toList());

    }


    @PostMapping
    ResponseEntity<CarrierCodeResponse> create(@RequestBody CarrierCodeRequest request)
    {
        final var result = carrierCodeService.save(fromRequest(request));
        return ResponseEntity.created(
                URI.create("/carrier_codes/" + result.carrierCode().value())
        ).body(toResponse(result));
    }



    private static CarrierCodeResponse toResponse(final CarrierCode code) {
        return new CarrierCodeResponse(
                code.carrierCode().value(),
                code.icaoCarrierCode(),
                code.carrierCodeName(),
                code.remark()
        );
    }

    private static CarrierCode fromRequest(final CarrierCodeRequest request) {
        return new CarrierCode(
                new CarrierCodeId(request.carrierCode()),
                request.icaoCarrierCode(),
                request.carrierCodeName(),
                request.remark()
        );
    }

}
