FROM tomcat:8.0-alpine

LABEL description="SimplyLearn Java Maven Jenkins Demo Project"

EXPOSE 8080

ADD ./target/demo-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/

CMD ["catalina.sh", "run"]


