FROM thaninp2021/ubuntu-focal-jdk8-maven36-tesseract41:latest

ARG DEBIAN_FRONTEND=noninteractive
ARG DEBCONF_NONINTERACTIVE_SEEN=true

COPY target/springboot-tesseract-render-railway-1.0.jar app.jar

EXPOSE 80
ENTRYPOINT ["java","-Xmx512m","-jar","/app.jar"]