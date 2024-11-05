# IMAGEN MODELO
FROM openjdk:17-jdk-slim

# ACTUALIZAR Y INSTALAR CURL
RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*

# DEFINIR DIRECTORIO RAIZ DE NUESTRO CONTENEDOR
WORKDIR /root

# COPIAR Y PEGAR ARCHIVOS DENTRO DEL CONTENEDOR
COPY ./.mvn /root/.mvn
COPY ./mvnw /root
COPY ./pom.xml /root

EXPOSE 8761

# DAR PERMISOS DE EJECUCIÓN AL SCRIPT mvnw
RUN chmod +x /root/mvnw

# DESCARGAR LAS DEPENDENCIAS
RUN ./mvnw dependency:go-offline

# COPIAR EL CODIGO FUENTE DENTRO DEL CONTENEDOR
COPY ./src /root/src

# CONSTRUIR NUESTRA APLICACION
RUN ./mvnw clean install -DskipTests -e

# LEVANTAR NUESTRA APLICACION CUANDO EL CONTENEDOR INICIE
ENTRYPOINT ["java","-jar","/root/target/crud-0.0.1-SNAPSHOT.jar"]