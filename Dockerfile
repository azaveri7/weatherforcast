FROM openjdk:11
LABEL maintainer="Anand Zaveri"
ENV APP_HOME=/usr/app/
ENV JAR_FILE=target/weatherforcast-0.0.1-SNAPSHOT.jar
WORKDIR $APP_HOME
COPY target/weatherforcast-0.0.1-SNAPSHOT.jar $APP_HOME
EXPOSE 8081
ENTRYPOINT ["java","-jar","weatherforcast-0.0.1-SNAPSHOT.jar"]