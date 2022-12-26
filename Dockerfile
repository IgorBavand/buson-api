FROM openjdk:11
ENV TZ=America/Fortaleza
LABEL maintainer="igor.com.br"
ARG JAR_FILE=target/scraping-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} scraping-0.0.1-SNAPSHOT.jar
EXPOSE 3304
ENTRYPOINT ["java", "-jar", "/scraping-0.0.1-SNAPSHOT.jar"]