FROM openjdk:8-alpine


RUN apk add bash

COPY . /tmp
WORKDIR /tmp

EXPOSE 8080

CMD ["java","-jar","./build/libs/whitecrow.jar"]
