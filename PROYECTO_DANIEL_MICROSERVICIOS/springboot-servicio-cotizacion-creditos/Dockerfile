FROM openjdk:12
VOLUME /tmp
EXPOSE 9094
ADD ./target/springboot-servicio-cotizacion-creditos-0.0.1-SNAPSHOT.jar cotizacion-creditos.jar
CMD sleep 20
ENTRYPOINT ["java", "-jar","/cotizacion-creditos.jar"]