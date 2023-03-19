FROM openjdk:17-alpine

MAINTAINER  Cicero Ednilson <ciceroednilson@gmail.com>

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} ms-car-search.jar

RUN apk update && apk add bash

ENTRYPOINT ["java","-jar","/ms-car-search.jar"]