pipeline {
    agent any
    tools {
        maven 'Maven-Jenkins'
        jdk 'Java-Jenkins'
    }

    parameters {
        booleanParam(name: 'GREET', defaultValue: false, description: 'Greet or not')
        booleanParam(name: 'TEST', defaultValue: false, description: 'Test')
    }

    stages {
        stage('Package Stage') {
            when {
                expression { params.GREET == true }
                 expression { params.TEST == true }
             }
            steps {
                echo "Hello world"
                bat 'mvn clean package'
            }
        }
    }
}