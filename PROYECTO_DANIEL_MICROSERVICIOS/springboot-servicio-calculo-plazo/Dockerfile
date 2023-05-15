FROM openjdk:12
VOLUME /tmp
EXPOSE 9095
ADD ./target/springboot-servicio-plazo-0.0.1-SNAPSHOT.jar servicio-plazo.jar
ENTRYPOINT ["java", "-jar","/servicio-plazo.jar"]