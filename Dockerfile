FROM adoptopenjdk/openjdk16:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=trustytruthBot
ENV BOT_TOKEN=1072170979:AAGRfm5ZHcqxZNfZ5tzLPnplXFhI363dQ68
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]