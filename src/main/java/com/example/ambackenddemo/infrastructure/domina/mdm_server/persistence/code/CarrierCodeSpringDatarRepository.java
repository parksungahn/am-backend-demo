package com.example.ambackenddemo.infrastructure.domina.mdm_server.persistence.code;

import com.example.ambackenddemo.domain.mdm.CarrierCode;
import com.example.ambackenddemo.domain.mdm.CarrierCodeId;
import com.example.ambackenddemo.domain.mdm.CarrierCodeRepository;

import java.util.List;
import java.util.Objects;

public class CarrierCodeSpringDatarRepository implements CarrierCodeRepository {
    private final CarrierCodeJpaRepository carrierCodeJpaRepository;

    public CarrierCodeSpringDatarRepository(CarrierCodeJpaRepository carrierCodeJpaRepository)
    {
        this.carrierCodeJpaRepository = Objects.requireNonNull(carrierCodeJpaRepository);
    }

    @Override
    public List<CarrierCode> findall()
    {
        return carrierCodeJpaRepository.findAll().stream().map(CarrierCodeSpringDatarRepository::fromEntity).toList();
    }

    @Override
    public CarrierCode save(CarrierCode carrierCode)
    {
        return fromEntity(carrierCodeJpaRepository.save(toEntity(carrierCode)));
    }





    public static CarrierCode fromEntity(CarrierCodeEntity entity)
    {
        return new CarrierCode(
                new CarrierCodeId(entity.getCarrierCode()),
                entity.getIcaoCarrierCode(),
                entity.getCarrierCodeName(),
                entity.getRemark()
        );
    }

    public static CarrierCodeEntity toEntity(CarrierCode entity)
    {
        return new CarrierCodeEntity(
                entity.carrierCode().value(),
                entity.icaoCarrierCode(),
                entity.carrierCodeName(),
                entity.remark()
        );
    }
}
