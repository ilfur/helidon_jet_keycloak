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

## Try health and metrics

```
curl -s -X GET http://localhost:8080/health
{"outcome":"UP",...
. . .

# Prometheus Format
curl -s -X GET http://localhost:8080/metrics
# TYPE base:gc_g1_young_generation_count gauge
. . .

# JSON Format
curl -H 'Accept: application/json' -X GET http://localhost:8080/metrics
{"base":...
. . .

```

