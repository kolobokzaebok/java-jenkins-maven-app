FROM tomcat:latest

LABEL description="SimplyLearn Java Maven Jenkins Demo Project"

EXPOSE 8080

ADD ./target/java-jenkins-maven-app.war /usr/local/tomcat/webapps/

CMD ["catalina.sh", "run"]


