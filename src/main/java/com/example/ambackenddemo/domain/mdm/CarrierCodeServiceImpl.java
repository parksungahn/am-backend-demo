package com.example.ambackenddemo.domain.mdm;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service, @Repository, @Component  //--> 대신 CarrierCodeConfig
public class CarrierCodeServiceImpl implements CarrierCodeService{
    private final CarrierCodeRepository carrierCodeRepository;

    public CarrierCodeServiceImpl(final CarrierCodeRepository carrierCodeRepository)
    {
        this.carrierCodeRepository = carrierCodeRepository;
    }

    @Override
    public List<CarrierCode> retrieves()
    {
        return carrierCodeRepository.findall();
    }

    @Override
    public CarrierCode save(final CarrierCode carriercode)
    {
        return carrierCodeRepository.save(carriercode);
    }
}
