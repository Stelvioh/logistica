# Usa a imagem oficial do OpenJDK 17 no Alpine Linux como base para amd64
FROM eclipse-temurin:17-jdk-alpine

# Define o diretório de trabalho no contêiner
WORKDIR /app

# Copia o arquivo JAR construído pelo Maven para o diretório /app
COPY target/logistica-1.0.0.jar /app/logistica-1.0.0.jar

# Expõe a porta 8080 para o mundo exterior
EXPOSE 8080

# Comando a ser executado quando o contêiner for iniciado
CMD ["java", "-jar", "logistica.jar"]
