FROM openjdk:8-alpine

VOLUME /tmp

COPY ./build/libs/whitecrow.jar whitecrow.jar

CMD ["java", "-jar", "/whitecrow.jar"]
