# Build #
Manual :  `npm install`
docker :  `docker build --no-cache -t exercise-fe:v1 .`

# Run #
 Manual :  `npm start`
 docker :  `docker run  -it  --rm  -p 3000:3000  -e CHOKIDAR_USEPOLLING=true  exercise-fe:v1`

# Usage #
goto http://localhost:3000 and enjoy