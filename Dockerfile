FROM gradle:6.8.2-jdk15 as builder
RUN mkdir /usr/src/project
COPY . /usr/src/project
WORKDIR /usr/src/project
RUN gradle clean build

FROM adoptopenjdk/openjdk15:jre-15.0.2_7-alpine as layers
RUN apk --no-cache add ca-certificates
#RUN mkdir /project
COPY --from=builder /usr/src/project/build/libs/spring-boot-repository-rest-resource-0.0.1-SNAPSHOT.jar spring-boot-repository-rest-resource.jar
#WORKDIR /project
RUN java -Djarmode=layertools -jar spring-boot-repository-rest-resource.jar extract

FROM adoptopenjdk/openjdk15:jre-15.0.2_7-alpine
COPY --from=layers dependencies/ .
COPY --from=layers snapshot-dependencies/ .
COPY --from=layers spring-boot-loader/ .
COPY --from=layers application/ .
EXPOSE 8080
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]

#ENTRYPOINT ["java", "-jar", "spring-boot-repository-rest-resource-0.0.1-SNAPSHOT.jar"]
# or CMD java -jar spring-boot-repository-rest-resource-0.0.1-SNAPSHOT.jar
