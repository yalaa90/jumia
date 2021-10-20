FROM openjdk:8
ADD target/exercise-1.jar exercise.jar
ADD ./sample.db sample.db
EXPOSE 8080
ENTRYPOINT ["java","-jar","exercise.jar"]