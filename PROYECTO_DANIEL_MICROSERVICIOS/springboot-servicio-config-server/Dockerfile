FROM openjdk:12
VOLUME /tmp
EXPOSE 8888
ADD ./target/springboot-servicio-config-0.0.1-SNAPSHOT.jar servicio-config.jar
ENTRYPOINT ["java", "-jar","/servicio-config.jar"]