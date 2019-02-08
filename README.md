## Example of SpringData @RepositoryRestResource with JSR 303 (Java Bean Validation) and JsonSerialization annotation



### Rest URLs 

GET, POST, DELETE , UPDATE  http://localhost:8080/customers

GET http://localhost:8080/customers/1

### Search Queries
GET http://localhost:8080/customers/search/findByLastName?lastName=lastname

GET http://localhost:8080/customers/search/findByFirstName?firstName=firstname

GET http://localhost:8080/customers/search/findByCompany?company=company



### Cloud Url

https://customer.cfapps.eu10.hana.ondemand.com/customers

### HATEOAS (Hypermedia as the Engine of Application State)

http://localhost:8080/profile/customers

### Sample Post payload

        {
            "firstName": "firstname",
            "lastName" : "lastname",
            "company" : "company",
            "rate" : 5.0
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

### References: 

- http://mrbool.com/rest-server-with-spring-data-spring-boot-and-postgresql/34023
- https://dzone.com/articles/building-a-data-repository-with-spring-data
- https://spring.io/guides/gs/accessing-data-rest/