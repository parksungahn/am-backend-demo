package com.example.ambackenddemo.infrastructure.domina.mdm_server.persistence.code;

import com.example.ambackenddemo.domain.mdm.CarrierCode;
import com.example.ambackenddemo.domain.mdm.CarrierCodeId;
import com.example.ambackenddemo.domain.mdm.CarrierCodeRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

//@Service, @Repository, @Component --모두(Component포함됨.) Bean이 생성됨.    //--대신->CarrierCodeRepositoryConfig
class CarrierCodeSpringDataRepository implements CarrierCodeRepository {
    private final CarrierCodeJpaRepository carrierCodeJpaRepository;

    public CarrierCodeSpringDataRepository(CarrierCodeJpaRepository carrierCodeJpaRepository)
    {
        this.carrierCodeJpaRepository = Objects.requireNonNull(carrierCodeJpaRepository);
    }
    @Override
    public List<CarrierCode> findAll() {
        return carrierCodeJpaRepository.findAll().stream().map(CarrierCodeSpringDataRepository::fromEntity).toList();
    }

    @Override
    public Optional<CarrierCode> findById(CarrierCodeId id) {
        return carrierCodeJpaRepository.findById(id.value()).map(CarrierCodeSpringDataRepository::fromEntity);
    }

    @Override
    public CarrierCode save(CarrierCode carrierCode) {
        return fromEntity(carrierCodeJpaRepository.save(toEntity(carrierCode)));
    }

    @Override
    @Transactional
    public Optional<CarrierCode> update(CarrierCode carrierCode) {
        Optional<CarrierCodeEntity> updateEntity = carrierCodeJpaRepository.findById(
                carrierCode.carrierCode().value()
        );

        updateEntity.ifPresent((it) -> it.update(carrierCode));

        return updateEntity.map(CarrierCodeSpringDataRepository::fromEntity);
    }

    @Override
    public void deleteById(CarrierCodeId id) {
        carrierCodeJpaRepository.deleteById(id.value());
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
