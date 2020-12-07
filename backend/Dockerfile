FROM openjdk:11.0.9.1-jdk as BUILD
COPY . /build
CMD chmod -R 777 /build
WORKDIR /build
RUN ./gradlew --no-daemon build

FROM openjdk:11.0.9.1-jre
EXPOSE 8080
RUN mkdir /app
COPY --from=build /build/build/libs/*fizzbuzz*.jar /app/fizzbuzz.jar
ENTRYPOINT ["java","-jar","/app/fizzbuzz.jar"]
