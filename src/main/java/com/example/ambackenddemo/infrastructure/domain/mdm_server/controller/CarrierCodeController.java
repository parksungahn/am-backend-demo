package com.example.ambackenddemo.infrastructure.domain.mdm_server.controller;

import com.example.ambackenddemo.domain.mdm.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Objects;

//--http://localhost:8080/carrier_code
@RestController
@RequestMapping("/carrier_code")
class CarrierCodeController {
    private final CarrierCodeService carrierCodeService;

    CarrierCodeController(CarrierCodeService carrierCodeService)
    {
        this.carrierCodeService = Objects.requireNonNull(carrierCodeService);;
    }

    //--전체조회 - http://localhost:8080/carrier_code
    @GetMapping
    ResponseEntity<List<CarrierCodeResponse>> retrieves() {
        return ResponseEntity.ok(
                carrierCodeService.retrieves()
                .stream()
                .map(CarrierCodeController::toResponse)
                .toList());
    }


//    @GetMapping("/{carrierCode}")
//    ResponseEntity<CarrierCodeResponse> retrieve(@PathVariable(name = "carrierCode") final String carrierCode) {
//        return carrierCodeService.retriveById(new CarrierCodeId(carrierCode))
//                .map(CarrierCodeController::toResponse)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }




    //--신규저장1
//    @PostMapping
//    CarrierCodeResponse create(@RequestBody CarrierCodeRequest request)
//    {
//        return toResponse(carrierCodeService.save(fromRequest(request)));
//    }




    //--http://localhost:8080/carrier_code
    //--post 쿼리스트링 아닌,BODY 에입력
//    {
//        "carrierCode":"KE"
//            ,"icaoCarrierCode":"KE"
//            ,"carrierCodeName":"KE"
//            ,"remark":"hi sanpark"
//    }
    //--신규저장2
    @PostMapping
    ResponseEntity<CarrierCodeResponse> create(@RequestBody CarrierCodeRequest request) {
        final var result = carrierCodeService.save(fromRequest(request));
        return ResponseEntity.created(
                        URI.create("/carrier_codes/" + result.carrierCode().value()))
                .body(toResponse(result));
    }

    @PutMapping("/{carrierCode}")
    ResponseEntity<CarrierCodeResponse> update(@RequestBody CarrierCodeRequest request) {
        return carrierCodeService.update(fromRequest(request))
                .map(CarrierCodeController::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //--http://localhost:8080/carrier_code/KE
    @DeleteMapping("/{carrierCode}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable(name = "carrierCode") final String carrierCode) {
        carrierCodeService.deleteById(new CarrierCodeId(carrierCode));
    }

    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ExceptionHandler(DataIntegrityViolationException.class)
    void handleDuplicateCarriercode() {
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
