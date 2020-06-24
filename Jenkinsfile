pipeline {
    agent any
    tools {
        maven 'Maven-Jenkins'
        jdk 'Java-Jenkins'
    }

    stages {
        stage('Package Stage') {
            steps {
                sh 'mvn clean package -Dmaven.test.skip=true'
            }
        }
    }
}