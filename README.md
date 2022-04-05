# User REST API example
This is a simple example how you can use spring boot + mongodb + docker to create a rest api. Any suggestions, new features or corrections are welcome!

- [x] Spring Boot
- [x] Spring Data
- [x] MongoDB
- [x] Log4j2 (instead of logback)
- [x] Unit Test
- [ ] Docker

**System requirements**
- JDK 17
- Maven
- ~~Docker~~

## API documentation


## Build and run application
The file [docker-compose.yaml](docker-compose.yaml) contains all the necessary settings to configure the environment.
The rest api application will be available at http://localhost:8080.

#Access
Access http://localhost:8080/api/v1/users