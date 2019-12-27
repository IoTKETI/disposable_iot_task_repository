# Task Repository

- 전체 정보

  - Documentation 폴더
    - API 명세서
      - DB 정보
  
- 사전 작업

  - Postgresql db 설치
    - 하위폴더 Documentation 내의 postgresql 설치 가이드 v0.1.pptx 참고
  - ddl 적용
    - psql -U "UserId" -f "경로/task_service_backup_191226.sql"
    - table 생성 및 예제(row) 정보들이 포함되어 있음
  - .yml 파일에서 해당 db의 경로 설정
  - .yml 파일에서 deploy API의 url 정보

- Maven build (빌드)

  - Dev
    - mvn -Dspring.profiles.active=dev clean package
  - Local
    - mvn -Dspring.profiles.active=local clean package

- 실행

  - Dev

    - java -jar -Dspring.profiles.active=dev taskservice-0.0.1-SNAPSHOT.jar

  - Local

    - java -jar -Dspring.profiles.active=local taskservice-0.0.1-SNAPSHOT.jar

  - Shell script 사용

    - 해당 폴더 내에서 task_service 최상위 폴더 git pull (Id: IoTKETI pw:keti12#)

      ```shell
      $ git pull
      $ ./depoly-task-service
      ```

      

- Config (설정)

  - src/main/resources/ 하위

  - application-dev.yml

  - application-local.yml

  - 목록

    | property                                  | Sample                                           | Description                                  |
    | ----------------------------------------- | ------------------------------------------------ | -------------------------------------------- |
    | server.port                               | 8181                                             | 포트정보                                     |
    | spring.datasource.driverClassName         | org.postgresql.Driver                            | jdbc 드라이버                                |
    | spring.datasource.url                     | jdbc:postgresql://104.199.128.18:5432/disposable | Db url                                       |
    | spring.datasource.username                | postgres                                         | db 유저 이름                                 |
    | spring.datasource.password                | 123123                                           | db 유저 패스워드                             |
    | spring.jackson.default-property-inclusion | NON_EMPTY                                        | 정보 반환시 null을 가진 필드는 반환하지 않음 |
    | mybatis.mapper-locations                  | classpath:/mappers/*.xml                         | Mapper scan을 위한 정보                      |
    | service.url                               | http://localhost:8080/cloudServer/deploy         | deploy를 위한 deploy api url 정보            |

    
