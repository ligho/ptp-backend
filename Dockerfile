FROM java:8-jre-alpine

MAINTAINER angrytest <thx_phila@yahoo.com>

COPY target/cov.jar .

EXPOSE 8080

CMD ["java","-jar","cov.jar"]
