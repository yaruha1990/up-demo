pipeline {
    agent any
    tools {
        maven 'Maven-Jenkins'
        jdk 'Java-Jenkins'
    }

    parameters {
        booleanParam(name: 'greet', defaultValue: false, description: 'Greet or not')
    }

    stages {
        stage('Package Stage') {
            when {$greet == true}
            steps {
                echo "Hello world"
                bat 'mvn clean package -Dmaven.test.skip=true'
            }
        }
    }
}