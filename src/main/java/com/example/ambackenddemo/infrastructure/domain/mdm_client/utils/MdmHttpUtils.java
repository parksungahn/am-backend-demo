package com.example.ambackenddemo.infrastructure.domain.mdm_client.utils;

import com.example.ambackenddemo.domain.mdm.CarrierCode;
import com.example.ambackenddemo.domain.mdm.CarrierCodeId;
import com.example.ambackenddemo.domain.mdm.CarrierCodeRequest;
import com.example.ambackenddemo.domain.mdm.CarrierCodeResponse;

public class MdmHttpUtils {
    private MdmHttpUtils() {
    }

    public static CarrierCodeResponse toCarrierCodeResponse(final CarrierCode carrierCode) {
        return new CarrierCodeResponse(
                carrierCode.carrierCode().value(),
                carrierCode.icaoCarrierCode(),
                carrierCode.carrierCodeName(),
                carrierCode.remark()
        );
    }

    public static CarrierCode fromCarrierCodeRequest(final CarrierCodeRequest request) {
        return new CarrierCode(
                new CarrierCodeId(request.carrierCode()),
                request.icaoCarrierCode(),
                request.carrierCodeName(),
                request.remark()
        );
    }

//    public static AircraftVersionResponse toAircraftVersionResponse(final AircraftVersion aircraftVersion) {
//        return new AircraftVersionResponse(
//                aircraftVersion.aircraftVersionId().value(),
//                aircraftVersion.carrierCode().value(),
//                aircraftVersion.aircraftTypeCode(),
//                aircraftVersion.aircraftVersionCode(),
//                aircraftVersion.aircraftGroupCode(),
//                aircraftVersion.aircraftConfigurationValue(),
//                aircraftVersion.paxCargoDivisionCode().name(),
//                aircraftVersion.bodyDivisionCode().name(),
//                aircraftVersion.taxiFuelWeight(),
//                aircraftVersion.minCenterTankFuelWeight(),
//                aircraftVersion.aircraftLoadAvailWeight(),
//                aircraftVersion.maxWingTankFuelWeight(),
//                aircraftVersion.remark()
//        );
//    }
//
//    public static AircraftVersion fromAircraftVersionRequest(
//            final AircraftVersionId id,
//            final AircraftVersionRequest request
//    ) {
//        return new AircraftVersion(
//                id,
//                new CarrierCodeId(request.carrierCode()),
//                request.aircraftTypeCode(),
//                request.aircraftVersionCode(),
//                request.aircraftGroupCode(),
//                request.aircraftConfigurationValue(),
//                request.paxCargoDivisionCode(),
//                request.bodyDivisionCode(),
//                request.taxiFuelWeight(),
//                request.minCenterTankFuelWeight(),
//                request.aircraftLoadAvailWeight(),
//                request.maxWingTankFuelWeight(),
//                request.remark()
//        );
//    }
//
//    public static PortCodeResponse toPortCodeResponse(final PortCode portCode) {
//        return new PortCodeResponse(
//                portCode.portCode().value(),
//                portCode.portCodeName(),
//                portCode.countryCode(),
//                portCode.etcCountryCode(),
//                portCode.countryCodeName(),
//                portCode.regionCode(),
//                portCode.gmtOffsetTime(),
//                portCode.summerTimeGmtOffsetTime(),
//                portCode.summerTimeStartDate(),
//                portCode.summerTimeEndDate(),
//                portCode.baggageActualModeSupportYn(),
//                portCode.bulkLoadAvailYn(),
//                portCode.remark()
//        );
//    }
//
//    public static PortCode fromPortCodeRequest(final PortCodeRequest request) {
//        return new PortCode(
//                new PortCodeId(request.portCode()),
//                request.portCodeName(),
//                request.countryCode(),
//                request.etcCountryCode(),
//                request.countryCodeName(),
//                request.regionCode(),
//                request.gmtOffsetTime(),
//                request.summerTimeGmtOffsetTime(),
//                request.summerTimeStartDate(),
//                request.summerTimeEndDate(),
//                request.baggageActualModeSupportYn(),
//                request.bulkLoadAvailYn(),
//                request.remark()
//        );
//    }
}
