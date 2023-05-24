# Getting Started

### Reference Documentation

########################## Aggregation

Infrastructure / aggregation / winload.mdm.client
----------------- Controller
- MdmCarrierCodeController

Domain / mdm
- CarrierCodeReactiveService (인터페이스)

Infrastructure / domain / mdm-client
- CarrierCodeClientReactiveService implements CarrierCodeReactiveService (구현체)
  ...public Mono<CarrierCode> getCarrierCode(final CarrierCodeId id)
  ...public Flux<CarrierCode> getCarrierCodes



########################## 도메인 - RestAPI
----------------- 순서
CarrierCodeController -> CarrierCodeService -> CarrierCodeServiceImpl
-> CarrierCodeRepository -> CarrierCodeSpringDataRepository -> CarrierCodeEntity


----------------- controller
Infrastructure / domain / mdm-server / controller
- CarrierCodeController
- record - [CarrierCodeRequest]
- record - [CarrierCodeResponse]


----------------- service
Domain / mdm
- CarrierCodeService (인터페이스)
- CarrierCodeServiceImpl (구현체)
- CarrierCodeRepository - (인터페이스-CarrierCodeSpringDataRepository)
  ...record [CarrierCode]

----------------- repository
Infrastructure / domain / mdm-server / persistence.code
- CarrierCodeSpringDataRepository implements CarrierCodeRepository (구현체)   
  --CarrierCode fromEntity
  --CarrierCodeEntity toEntity
- CarrierCodeJpaRepository  (인터페이스)
- CarrierCodeEntity (Entity 테이블)

Infrastructure / domain / mdm-server / config
CarrierCodeConfig (@Bean)




