FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY ./target/calendar-1.0-SNAPSHOT.jar /app/app.jar

# 运行 Java 应用，假设生成的 JAR 文件位于 target 目录
CMD ["java", "-jar", "/app/app.jar"]