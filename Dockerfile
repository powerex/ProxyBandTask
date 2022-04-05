#FROM openjdk:17-alpine
#COPY target/UserServiceAPI.jar /UserServiceAPI.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","/UserServiceAPI.jar"]

FROM maven:latest

COPY ./ ./

RUN mvn clean package

CMD ["java", "-jar", "target/UserServiceAPI.jar"]