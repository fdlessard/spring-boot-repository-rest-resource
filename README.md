## spring-boot-repository-rest-resource

[![Build Status](https://travis-ci.org/fdlessard/spring-boot-repository-rest-resource.svg)](https://travis-ci.org/fdlessard/spring-boot-repository-rest-resource)
[![License](http://img.shields.io/:license-mit-blue.svg)](https://github.com/fdlessard/spring-boot-repository-rest-resource/blob/master/LICENSE)

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
