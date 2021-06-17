FROM adoptopenjdk/openjdk11:latest

EXPOSE 8080

ADD target/casa-do-codigo.jar casa-do-codigo.jar

ENTRYPOINT ["java", "jar", "casa-do-codigo.jar"]

#URL do Repositório: https://hub.docker.com/repository/docker/guilhermesantosdocker/casa-do-codigo