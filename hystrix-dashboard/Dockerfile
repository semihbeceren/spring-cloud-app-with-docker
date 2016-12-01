FROM frolvlad/alpine-oraclejdk8:slim

MAINTAINER Semih BECEREN <smhbeceren@gmail.com>

ADD /target/hystrix-dashboard.jar app.jar
RUN sh -c 'touch /app.jar'
EXPOSE 9411
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]