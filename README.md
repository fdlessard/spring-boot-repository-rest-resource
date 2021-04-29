## spring-boot-repository-rest-resource
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=io.fdlessard.codebites%3Aspring-boot-repository-rest-resource&metric=alert_status)](https://sonarcloud.io/dashboard?id=io.fdlessard.codebites%3Aspring-boot-repository-rest-resource)

[![CI Pipeline](https://github.com/fdlessard/spring-boot-repository-rest-resource/actions/workflows/ci-pipeline.yml/badge.svg)](https://github.com/fdlessard/spring-boot-repository-rest-resource/actions/workflows/ci-pipeline.yml)[![License](http://img.shields.io/:license-mit-blue.svg)](https://github.com/fdlessard/spring-boot-repository-rest-resource/blob/master/LICENSE)

## Example of SpringData @RepositoryRestResource with JSR 303 (Java Bean Validation) and JsonSerialization annotation



### Rest URLs 

GET, POST, DELETE , UPDATE  http://localhost:8080/customers

GET http://localhost:8080/customers/1


### POST http://localhost:8080/customers

#### Create a new customer with an existing customer category

    POST
    {
      "lastName": "last-name-1",
      "firstName": "first-name-1",
      "company": "company-1"
    }  
    
 ### PUT http://localhost:8080/customers/1
   
 #### Update customer 1 (overide all the fields with the provided/unprovided values)
 
    {

      "lastName": "last-name-1",
      "firstName": "first-name-1",
      "company": "company-1"
    }


 ### PATCH http://localhost:8080/customers/1
   
 #### Update customer 1 (overide the provided field values)
 
    {
      "company": "company-1-updated"
    }

### HATEOAS (Hypermedia as the Engine of Application State)

http://localhost:8080/profile/customers

### Sample Post payload

        {
            "firstName": "firstname",
            "lastName" : "lastname",
            "company" : "company",
        }
        
### Sample Get HATEOAS response        

        {
            "lastName": "lastname",
            "firstName": "firstname",
            "company": "company",
            "rate": 5,
            "_links": {
                "self": {
                    "href": "http://localhost:8080/customers/1"
                },
                "customer": {
                    "href": "http://localhost:8080/customers/1"
                }
            }


### Docker

docker build .
docker-compose build .
docker-compose up


### References: 

 - http://mrbool.com/rest-server-with-spring-data-spring-boot-and-postgresql/34023
 - https://dzone.com/articles/building-a-data-repository-with-spring-data
 - https://spring.io/guides/gs/accessing-data-rest/


 - https://hub.docker.com/_/gradle
 - https://hub.docker.com/_/adoptopenjdk
 - https://hub.docker.com/r/adoptopenjdk/openjdk15


  Multi layer (Multi stage) docker

 - https://snyk.io/blog/docker-for-java-developers/
 - https://codefresh.io/docker-tutorial/create-docker-images-for-java/
 - https://phauer.com/2019/no-fat-jar-in-docker-image/
 - https://www.baeldung.com/docker-layers-spring-boot
 - https://springframework.guru/why-you-should-be-using-spring-boot-docker-layers/
 - https://medium.com/better-programming/simplified-docker-image-builds-for-java-microservices-316648e0de81

 - https://docs.docker.com/develop/develop-images/multistage-build/

 Buildpack

 - https://www.baeldung.com/spring-boot-docker-images
 - https://medium.com/faun/creating-a-docker-image-using-cloud-native-buildpacks-in-spring-boot-19ff81b5209d
 - https://medium.com/techwasti/spring-boot-cloud-native-buildpacks-and-layered-jars-bbe74f80e983

 - https://cloud.google.com/blog/topics/developers-practitioners/comparing-containerization-methods-buildpacks-jib-and-dockerfile


Cloud Native Buildpacks (CNB) 

 - https://solocoding.dev/blog/eng_docker_buildpacks
 - https://github.com/paketo-buildpacks/spring-boot

 - https://blog.frankel.ch/hitchhiker-guide-containerizing-java-apps/
 - https://zoltanaltfatter.com/2020/12/26/build-images-with-cloud-native-buildpacks/





48c84ece88a049729e28421607eca26f


https://www.testcontainers.org/supported_docker_environment/continuous_integration/dind_patterns/
https://www.gitmemory.com/issue/testcontainers/testcontainers-java/613/466072002
https://github.com/testcontainers/testcontainers-java/issues/613

https://stackoverflow.com/questions/59579845/testcontainers-running-testcontainers-tests-inside-docker-running-docker-ins
https://jpetazzo.github.io/2015/09/03/do-not-use-docker-in-docker-for-ci/


docker run -p 8081:8080 -p 50000:50000 -v $PWD:$PWD -w $PWD -v /var/run/docker.sock:/var/run/docker.sock -v /Users/fdlessard/jenkins_home:/var/jenkins_home jenkins/jenkins:lts-jdk11





https://www.jenkins.io/doc/book/installing/docker/
https://www.jenkins.io/doc/book/using/using-agents/


docker network ls
docker network create jenkins

docker run \
--name jenkins-docker \
--rm \
--detach \
--privileged \
--network jenkins \
--network-alias docker \
--env DOCKER_TLS_CERTDIR=/certs \
--volume /Users/fdlessard/jenkins-docker-certs:/certs/client \
--volume /Users/fdlessard/jenkins-home:/var/jenkins_home \
--publish 2376:2376 \
docker:dind \
--storage-driver overlay2






docker run \
--name jenkins-blueocean \
--rm \
--detach \
--network jenkins \
--env DOCKER_HOST=tcp://docker:2376 \
--env DOCKER_CERT_PATH=/certs/client \
--env DOCKER_TLS_VERIFY=1 \
--publish 8081:8080 \
--publish 50000:50000 \
--volume /Users/fdlessard/jenkins-home:/var/jenkins_home \
--volume /Users/fdlessard/jenkins-docker-certs:/certs/client:ro \
myjenkins-blueocean:1.1 


docker run -d --rm --name=agent1 -p 22:22 -e "JENKINS_AGENT_SSH_PUBKEY=AAAAB3NzaC1yc2EAAAADAQABAAABgQC33TRjXLikGhX1wLldGB+0Ucfnez7+G0KNS/JlMLTdXeeIccjapnIUfPR2+mS5Ew4x9pLLG1Szi/ka3XePNosMA0pQJTKtaA0jYHEbim+yzrA684ITLZMB5sthaEEPVdOsGv3Rbkvjlzn7JHY8mzz/tGlHy9wuEda68+jEjWFVTl2HmTpz2BwDUuefYQSL8fDVul6FcKpId7DS+LDlFkZRZ6G44z+iVcoTMQA3SRghiDqSi+VhHTwNbKuDtmmZcEgJaM4Y3AcYUVvis9IPtzgvoD86hvqQFLNhjXb5iUDzDwqkFVTbooVbhv0/SRsqCyeihBoMCFZg1vTScIhGef2q4Bype3sSprpZJPlRxQQr+lmblg6xurcS4oH2eOk6w7aztyb+77IVWbtGq+JCO/XlRrQtEm2o27DOQA6nC8ltohEGgqZF30VVqMTB5rVq9zEhCUL+MLmXNlAUacAaPM3RF0j1GXPdklEJTx7MSei/QKMjQdlvdbC6rKEpSJVxYFU=" jenkins/ssh-agent:alpine



7633f15fa72e452898a5b55c0d536134