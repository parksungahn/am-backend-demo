package com.example.ambackenddemo.infrastructure.domain.mdm_server.persistence;

import com.example.ambackenddemo.domain.mdm.CarrierCode;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
class CarrierCodeEntity {
    @Id
    private String carrierCode;
    private String icaoCarrierCode;
    private String carrierCodeName;
    private String remark;

    protected CarrierCodeEntity()
    {

    }

    public CarrierCodeEntity(String carrierCode, String icaoCarrierCode, String carrierCodeName, String remark) {
        this.carrierCode = Objects.requireNonNull(carrierCode);
        this.icaoCarrierCode = Objects.requireNonNull(icaoCarrierCode);
        this.carrierCodeName = Objects.requireNonNull(carrierCodeName);
        this.remark = Objects.requireNonNull(remark);
    }

    public String getCarrierCode() {
        return carrierCode;
    }

    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    public String getIcaoCarrierCode() {
        return icaoCarrierCode;
    }

    public void setIcaoCarrierCode(String icaoCarrierCode) {
        this.icaoCarrierCode = icaoCarrierCode;
    }

    public String getCarrierCodeName() {
        return carrierCodeName;
    }

    public void setCarrierCodeName(String carrierCodeName) {
        this.carrierCodeName = carrierCodeName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void update(CarrierCode carrierCode) {
        icaoCarrierCode = carrierCode.icaoCarrierCode();
        carrierCodeName = carrierCode.carrierCodeName();
        remark = carrierCode.remark();
    }

//    @Override
//    public String getId() {
//        return carrierCode;
//    }
//
//    @Override
//    public boolean isNew() {
//        return true;
//    }
}
