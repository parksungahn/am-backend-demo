# Getting Started

### 필수파일
- domain.mdm 쪽만 모두 public
- infrastructure 는 모두 public 제외
---

####################################################### Aggregation
- 1 - CarrierCodeReactiveService        (인터페이스-domain연결용)           --Domain / mdm
- 2 - CarrierCodeClientReactiveService  (구현체-domain controller 호출)    --Infrastructure / domain / mdm-client
- 3 - MdmCarrierCodeController          (Congtroller)                    --Infrastructure / domain / mdm-server
- 4 - MdmHttpUtils                      (utils for Congtroller)          --Infrastructure / domain / mdm-client / utils
- ---
- 5 - CarrierCodeClientReactiveServiceAutoConfiguration                  --Infrastructure / domain / mdm-client
- 6 - MdmClientProperties                                                --Infrastructure / domain / mdm-client





#######################################################  도메인 - RestAPI

- 1 - CarrierCode                     (Class)       --Domain / mdm
- 2 - CarrierCodeRepository           (인터페이스)    --Domain / mdm
- 3 - CarrierCodeRequest              (Record)      --Domain / mdm
- 4 - CarrierCodeResponse             (Record)      --Domain / mdm
- 5 - CarrierCodeService              (인터페이스)    --Domain / mdm
- 6 - CarrierCodeServiceImpl          (구현체)       --Domain / mdm
- ---
- 7 - CarrierCodeServiceConfig        (Service Config)     --Infrastructure / domain / mdm-server / config
- 8 - CarrierCodeController           (컨트롤러)             --Infrastructure / domain / mdm-server / controller
- 9 - CarrierCodeEntity               (Entity)             --Infrastructure / domain / mdm-server / persistnece
- 10- CarrierCodeJpaRepository        (Repository)         --Infrastructure / domain / mdm-server / persistnece
- 11- CarrierCodeRepositoryConfig     (Repository Config)  --Infrastructure / domain / mdm-server / persistnece
- 12- CarrierCodeSpringDataRepository (구현체)              --Infrastructure / domain / mdm-server / persistnece





