FROM openjdk:15-jdk-alpine

ADD ./build/libs/transaction-0.0.1.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/transaction-0.0.1.jar"]

EXPOSE 8080