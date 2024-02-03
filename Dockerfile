# Usa a imagem oficial do OpenJDK 17 no Alpine Linux como base para amd64
FROM adoptopenjdk:17-jdk-hotspot-bionic

# Define o diretório de trabalho no contêiner
WORKDIR /app

# Copia o arquivo JAR construído pelo Maven para o diretório /app
COPY target/logistica-*.jar /app/logistica.jar

# Expõe a porta 8080 para o mundo exterior
EXPOSE 8080

# Comando a ser executado quando o contêiner for iniciado
CMD ["java", "-jar", "logistica.jar"]
