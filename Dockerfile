FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/jumia-0.0.1-SNAPSHOT.jar app.jar
COPY ./sample.db ./sample.db
ENTRYPOINT ["java","-jar","app.jar"]
# COPY ./sample.db ./sample.db
EXPOSE 8080