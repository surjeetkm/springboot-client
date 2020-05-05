FROM openjdk:8
RUN mkdir -p /opt/store/
COPY ./target/springboot-mysql-client.jar /opt/store/
WORKDIR /opt/store/
EXPOSE 8080
CMD ["java", "-jar", "springboot-mysql-client.jar"]