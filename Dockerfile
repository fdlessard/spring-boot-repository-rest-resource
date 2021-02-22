# Multistage Docker buildfile

# Stage 1 - Build project - With JDK
FROM gradle:6.8.2-jdk15 as builder
RUN mkdir /project
COPY . /project
WORKDIR /project
RUN gradle clean bootJar

# Stage 2 - explode jar - With JRE
FROM adoptopenjdk/openjdk15:jre-15.0.2_7-alpine as layers
RUN apk --no-cache add ca-certificates
COPY --from=builder /project/build/libs/spring-boot-repository-rest-resource-0.0.1-SNAPSHOT.jar spring-boot-repository-rest-resource.jar
RUN java -Djarmode=layertools -jar spring-boot-repository-rest-resource.jar extract

# Stage 3 - Spring Boot Layers
FROM adoptopenjdk/openjdk15:jre-15.0.2_7-alpine
COPY --from=layers dependencies/ .
COPY --from=layers snapshot-dependencies/ .
COPY --from=layers spring-boot-loader/ .
COPY --from=layers application/ .
EXPOSE 8080
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]

