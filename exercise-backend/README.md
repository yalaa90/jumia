# Build #
Manual :  `mvn clean install`
docker :  `docker build --no-cache -t exercise:v1 .`

# Test #
`mvn test`

# Run #
 Manual :  `mvn spring-boot:run`
 docker :  `docker run -dp 8080:8080 exercise:v1`
