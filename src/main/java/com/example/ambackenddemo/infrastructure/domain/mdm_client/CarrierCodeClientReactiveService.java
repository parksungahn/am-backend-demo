package com.example.ambackenddemo.infrastructure.domain.mdm_client;

import com.example.ambackenddemo.domain.mdm.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

public class CarrierCodeClientReactiveService implements CarrierCodeReactiveService {
    private final String CARRIER_CODE_BASE_PATH = "/carrier_codes";
    private final WebClient webClient;

    public CarrierCodeClientReactiveService(WebClient webClient) {
        this.webClient = Objects.requireNonNull(webClient);
    }

    @Override
    public Flux<CarrierCode> getCarrierCodes() {
        return webClient.get()
                .uri(CARRIER_CODE_BASE_PATH)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(CarrierCodeResponse.class)
                .map(CarrierCodeClientReactiveService::fromResponse);
    }

    @Override
    public Mono<CarrierCode> createCarrierCode(final CarrierCode carrierCode) {
        return webClient.post()
                .uri(CARRIER_CODE_BASE_PATH)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(toRequest(carrierCode))
                .retrieve()
                .bodyToMono(CarrierCodeResponse.class)
                .map(CarrierCodeClientReactiveService::fromResponse)
                .onErrorResume(WebClientResponseException.class, it -> {
                    if (it.getStatusCode().isSameCodeAs(HttpStatus.CONFLICT)) {
                        return Mono.empty();
                    } else {
                        return Mono.error(it);
                    }
                });
    }

    private static CarrierCodeRequest toRequest(CarrierCode domain) {
        return new CarrierCodeRequest(
                domain.carrierCode().value(),
                domain.icaoCarrierCode(),
                domain.carrierCodeName(),
                domain.remark()
        );
    }

    private static CarrierCode fromResponse(CarrierCodeResponse response) {
        return new CarrierCode(
                new CarrierCodeId(response.carrierCode()),
                response.icaoCarrierCode(),
                response.carrierCodeName(),
                response.remark()
        );
    }



//    @Override
//    public Mono<CarrierCode> getCarrierCode(final CarrierCodeId id) {
//        return webClient
//                .get()
//                .uri(CARRIER_CODE_BASE_PATH + "/" + id.value())
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .bodyToMono(CarrierCodeResponse.class)
//                .map(CarrierCodeClientReactiveService::fromResponse)
//                .onErrorResume(WebClientResponseException.class, it -> {
//                    if (it.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
//                        return Mono.empty();
//                    } else {
//                        return Mono.error(it);
//                    }
//                });
//    }
//
//    @Override
//    public Mono<CarrierCode> updateCarrierCode(final CarrierCode carrierCode) {
//        return webClient.put()
//                .uri(CARRIER_CODE_BASE_PATH + "/" + carrierCode.carrierCode().value())
//                .accept(MediaType.APPLICATION_JSON)
//                .bodyValue(toRequest(carrierCode))
//                .retrieve()
//                .bodyToMono(CarrierCodeResponse.class)
//                .map(CarrierCodeClientReactiveService::fromResponse)
//                .onErrorResume(WebClientResponseException.class, it -> {
//                    if (it.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
//                        return Mono.empty();
//                    } else {
//                        return Mono.error(it);
//                    }
//                });
//    }
//
//    @Override
//    public Mono<Void> deleteCarrierCode(final CarrierCodeId id) {
//        return webClient.delete()
//                .uri(CARRIER_CODE_BASE_PATH + "/" + id.value())
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .bodyToMono(Void.class);
//    }



}
