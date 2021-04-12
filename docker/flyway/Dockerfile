FROM boxfuse/flyway
USER root
COPY /database /root/database/
WORKDIR /root/database/
CMD ["-url=jdbc:postgresql://postgres:5432/postgres-basic -user=postgres -password=postgres -schemas=example_schema -locations=filesystem:. migrate"]