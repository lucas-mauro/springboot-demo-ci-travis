@ECHO OFF
ECHO Compose deploying is starting
ECHO Services to deploy:
ECHO #Postgres
ECHO #Flyway
ECHO ###################################
docker-compose -f base-example.yml up --build postgres flyway
ECHO #####################################################
docker ps --format "{{.Names}}: Is running OK"
ECHO #####################################################
PAUSE