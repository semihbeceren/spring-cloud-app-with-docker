FROM frolvlad/alpine-oraclejdk8:slim

MAINTAINER Semih BECEREN <smhbeceren@gmail.com>

ADD /target/auth-service.jar app.jar
RUN sh -c 'touch /app.jar'
EXPOSE 9999
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]