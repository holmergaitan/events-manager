# App requeriments
Java version: 8

Gradle version: 4.0 or later to support org.springframework.boot plugin

# Configuration
In the root project, execute next command to perform a build: 
```
$ gradle clean build
```
In the root project, execute next command to run the application: 
```
$ gradle bootRun
```
The application listen in the 8080 port. You can access to the main page by next url: localhost:8080

# App endpoints
To send a new Even request, use the next endpoint: 
localhost:8080/events, POST method
```
  {
       "name": "Chicago White Sox vs. Chicago Cubs",
       "date": "2018-09-18",
       "venueDTO": {
           "name": "Wrigley Field",
           "city": "Chicago",
           "state": "IL"
       }
   }
```
To query all events, uste the next endpoint:
localhost:8080/events, GET method
```
  [
    {
         "name": "Chicago White Sox vs. Chicago Cubs",
         "date": "2018-09-18",
         "venueDTO": {
             "name": "Wrigley Field",
             "city": "Chicago",
             "state": "IL"
         }
     }
  ]
```
