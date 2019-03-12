FROM openjdk:8-alpine

VOLUME /tmp

COPY ./build/libs/whitecrow.jar whitecrow.jar

CMD ["java", "-jar", "-Xmx300m",  "-Xss512k", "/whitecrow.jar"]
