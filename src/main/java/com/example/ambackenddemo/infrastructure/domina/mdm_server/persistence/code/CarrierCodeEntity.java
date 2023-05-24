package com.example.ambackenddemo.infrastructure.domina.mdm_server.persistence.code;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CarrierCodeEntity {
    @Id
    private String carrierCode;
    private String icaoCarrierCode;
    private String carrierCodeName;
    private String remark;

    protected CarrierCodeEntity()
    {

    }

    public CarrierCodeEntity(String carrierCode, String icaoCarrierCode, String carrierCodeName, String remark) {
        this.carrierCode = carrierCode;
        this.icaoCarrierCode = icaoCarrierCode;
        this.carrierCodeName = carrierCodeName;
        this.remark = remark;
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
}
