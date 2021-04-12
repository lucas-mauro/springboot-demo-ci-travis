@ECHO OFF
ECHO Down base
ECHO Delete conatainers 
docker rm docker_flyway_1 && docker rm docker_postgres_1 
ECHO Delete images 
docker rmi flyway:postgres-basic && docker rmi postgres:12.1-alpine
ECHO Finished down of all services and deleted backend and flyway images
PAUSE