Sepotifay Service<a name="TOP"></a>
===================

## Prerequisites ##
* Oracle JDK 11
* Spring Boot
* PostgreSQL

## Installation ##
Use the Package manager [maven](https://maven.apache.org/download.cgi) to Install and build Sepotifay-service
```
mvn clean install
```

### Running Apps ###
```
java -jar target/sepotifay-0.0.1-SNAPSHOT.jar
```

## API ##

Get All Data Artist
```
GET : http://localhost:8081/artists
```
Get Data Artist By ID
```
GET : http://localhost:8081/artist/{id}
```
Get Data Artist Specification
```
GET : http://localhost:8081/artists?id={id}&name={name}&birthDate={birthDate}&birthPlace={birthPlace}&email={email}&phoneNumber={phoneNumber}&gender={gender}
```
Get Data Artist By Name and Gender
```
GET : http://localhost:8081/artists?name={name}&gender={gender}
```
Delete Data Artist By ID
```
Delete : http://localhost:8081/artist/{id}
```
Create Data New Artist
```
POST : http://localhost:8081/artists
```
```json
    Request  Body
    {
        "name" : " ",
        "birthDate" : " ",
        "birthPlace" : " ",
        "email" : " ",
        "phoneNumber" : " ",
        "gender" : " "
    }
```
Update Address Artist
```
PUT : http://localhost:8081/artist/update
```
``` json
    Request  Body
    {
        "name" : " ",
        "birthDate" : " ",
        "birthPlace" : " ",
        "email" : " ",
        "phoneNumber" : " ",
        "gender" : " "
    }
    
```

## Authors ##
* Albert Jeremi Manurung
* Email : manurungalbert250420@gmail.com
