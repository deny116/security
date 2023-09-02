call mvn clean package
docker build , -t security
docker stop security
docker rm security
docker run -p 8080:8080 security
