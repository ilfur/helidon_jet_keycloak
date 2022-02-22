# Helidon Quickstart MP

Sample Helidon MP project that includes one JWT-protected REST operation.

## Build and run

With JDK11+
```bash
mvn package
java -jar target/helidon-keycloak.jar
```

## Exercise the application

```
curl -X GET http://localhost:8080/hello/greet
{"message":"Hello World!"}
