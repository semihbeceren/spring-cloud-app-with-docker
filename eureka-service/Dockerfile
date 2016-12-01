FROM frolvlad/alpine-oraclejdk8:slim

MAINTAINER Semih BECEREN <smhbeceren@gmail.com>

ADD /target/eureka-service.jar app.jar
RUN sh -c 'touch /app.jar'
EXPOSE 8761
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]