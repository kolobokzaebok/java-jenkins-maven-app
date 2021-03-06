def app
pipeline {
    agent any
    stages {
        stage("compilation") {
            steps {
                echo 'pulling changes...'
                checkout scm
                echo 'building a new .war file from the pulled code...'
                sh "mvn clean install"
                echo 'building docker image...'
                script {
                    app = docker.build("kolobokzaebok/java-jenkins-maven-app")
                }
                echo 'pushing to docker hub...'
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerHub') {
                        app.push("${env.BUILD_NUMBER}")
                        app.push("latest")
                    }
                }
            }

        }
        stage("test") {
            steps {
                echo 'test stage...'
                sh "mvn test"
            }
        }
        stage("deployment") {
            steps {
                echo 'deployment stage...'
                echo 'pulling from docker hub...'
                script {
                    docker.image("kolobokzaebok/java-jenkins-maven-app:latest").pull()
                }
                echo 'running the java-jenkins-maven-app from the latest image downloaded from docker hub'
                script {
                    sh "docker run -d -p 7777:8080 kolobokzaebok/java-jenkins-maven-app:latest"
                }
            }
        }
        stage("cleanup") {
            steps {
                echo 'cleanup...'
                script {
                    sh "docker rm -f \$(docker ps -aq)"
                }
            }
        }
    }
}