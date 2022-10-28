FROM openjdk:8-jdk-alpine
MAINTAINER Dharmendra Kumar Kaushal <dharmendra.sd2014@gmail.com>
COPY ./target/hararoo-0.0.1.jar /
ENTRYPOINT [ "java", "-jar", "/hararoo-0.0.1.jar","--server.port=8080"]
EXPOSE 8080