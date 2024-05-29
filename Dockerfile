FROM eclipse-temurin:17-jdk-jammy as builder

WORKDIR /api
COPY build.gradle.kts settings.gradle.kts gradlew ./
COPY gradle/ gradle
RUN ./gradlew clean build || return 0
COPY ./src ./src
RUN ./gradlew clean build -x test

FROM eclipse-temurin:17-jre-jammy
WORKDIR /api
COPY --from=builder /api/build/libs/*.jar /api/*.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "/api/*.jar" ]
