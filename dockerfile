# Paso 1: Compilar la aplicación con Maven
FROM maven:3.8.8-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Paso 2: Ejecutar la aplicación con entorno gráfico
FROM eclipse-temurin:17-jre
WORKDIR /app

# Instalar librerías necesarias en Linux para soportar interfaces gráficas (AWT/Swing)
RUN apt-get update && apt-get install -y \
    libxext6 \
    libxrender1 \
    libxtst6 \
    libxi6 \
    && rm -rf /var/lib/apt/lists/*

# Copiar el archivo JAR compilado desde el paso anterior
COPY --from=build /app/target/*.jar app.jar

# Variable de entorno para que Java reconozca la pantalla compartida
ENV DISPLAY=host.docker.internal:0.0

# Comando para arrancar tu Main.java
CMD ["java", "-jar", "app.jar"]