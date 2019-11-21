pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Pull Latest Image') {
            steps {
                //sh
                bat "docker pull cmeatarun1988/selenium-docker"
            }
        }
        stage('Bring GRID up') {
            steps {
                //sh
                bat "docker-compose up -d hub chrome firefox"
            }
        }
        stage('Execute scripts') {
            steps {
                //sh
                bat "docker-compose up search-module book-flight-module"
            }
        }
        stage('Bring GRID down') {
            steps {
                //sh
                bat "docker-compose down"
            }
        }
    }
}