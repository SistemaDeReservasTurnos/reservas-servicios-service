

FROM maven:3.9.6-eclipse-temurin-17 AS build

#=========================================

WORKDIR /app

# Copiamos pom.xml y descargamos dependencias (cache)
COPY pom.xml .
RUN mvn -q -e -DskipTests dependency:go-offline

# Copiamos el código fuente
COPY src ./src

# se compila y se genera el JAR
RUN mvn clean package -DskipTests

# ============================
 Runtime stage (JRE)

FROM eclipse-temurin:17-jre

WORKDIR /app

# Copiar el JAR desde build stage
COPY --from=build /app/target/*.jar app.jar

# Variables de entorno
ENV JAVA_OPTS=""
ENV SPRING_PROFILES_ACTIVE=prod


EXPOSE 8082

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]

