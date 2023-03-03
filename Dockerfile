FROM maven:3.6.3-jdk-11-slim
WORKDIR /sampleprojecttech
COPY . .
RUN mvn clean install -DskipTests

CMD [ "java", "-jar", "target/spring-rest-api.war" ]
