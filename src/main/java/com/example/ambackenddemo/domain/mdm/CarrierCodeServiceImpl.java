package com.example.ambackenddemo.domain.mdm;

import java.util.List;

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
