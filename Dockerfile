#
# Build stage
#
FROM maven:4.0.0-jdk-17 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM openjdk:17
COPY --from=build /target/payroll-0.0.1-SNAPSHOT.jar payment.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","payment.jar"]