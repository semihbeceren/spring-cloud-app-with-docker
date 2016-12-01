FROM frolvlad/alpine-oraclejdk8:slim

MAINTAINER Semih BECEREN <smhbeceren@gmail.com>

ADD /target/config-service.jar app.jar
RUN sh -c 'touch /app.jar'
EXPOSE 8888
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]