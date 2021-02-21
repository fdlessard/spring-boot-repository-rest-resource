FROM gradle:6.8.2-jdk15 as build
RUN mkdir /usr/src/project
COPY . /usr/src/project
WORKDIR /usr/src/project
RUN gradle clean build

FROM adoptopenjdk/openjdk15:jre-15.0.2_7-alpine
RUN mkdir /project
COPY --from=build /usr/src/project/build/libs/spring-boot-repository-rest-resource-0.0.1-SNAPSHOT.jar /project/
WORKDIR /project
CMD java -jar spring-boot-repository-rest-resource-0.0.1-SNAPSHOT.jar
