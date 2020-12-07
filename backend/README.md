# Backend
Implemented as simple API on Spring Boot.
Run `./gradlew build` to test and build and `./gradlew bootRun` to start the app.
Alternatively, you can use `docker-compose up backend` from the repository root

You can use http://localhost:8080/swagger-ui.html to test the API.

# Implementation details
The largest Fizz Buzz Round is cached and used for other rounds ([by this decorator](./src/main/kotlin/cloud/oneio/task/fizzbuzz/service/CacheableRoundServiceDecorator.kt)):
* if current FizzBuzz goal is greater than cached, only the difference will be computed (iteratively)
* if current FizzBuzz goal is less than cached, sublist of cached result will be returned

The size of the currently cached value can be watched on http://localhost:8080/actuator/metrics/fizzbuzz.rounds.largest.
Of course, the cache is "pre-warmed" by the result of Fizz Buzz for 500.

# Metrics
Metrics are provided by actuator: http:/localhost:8080/actuator
