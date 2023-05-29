package com.example.ambackenddemo.domain.mdm;

import java.util.List;
import java.util.Optional;

//@Service, @Repository, @Component  //--> 대신 CarrierCodeConfig
public class CarrierCodeServiceImpl implements CarrierCodeService{
    private final CarrierCodeRepository carrierCodeRepository;

    public CarrierCodeServiceImpl(final CarrierCodeRepository carrierCodeRepository)
    {
        this.carrierCodeRepository = carrierCodeRepository;
    }


    @Override
    public List<CarrierCode> retrieves() {
        return carrierCodeRepository.findAll();
    }

    @Override
    public Optional<CarrierCode> retriveById(final CarrierCodeId id) {
        return carrierCodeRepository.findById(id);
    }

    @Override
    public CarrierCode save(final CarrierCode carrierCode) {
        return carrierCodeRepository.save(carrierCode);
    }

    @Override
    public Optional<CarrierCode> update(final CarrierCode carrierCode) {
        return carrierCodeRepository.update(carrierCode);
    }

    @Override
    public void deleteById(CarrierCodeId id) {
        carrierCodeRepository.deleteById(id);
    }
}
