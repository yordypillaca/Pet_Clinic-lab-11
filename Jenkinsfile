pipeline {
    agent any
    stages {
        stage('Clone') {
            steps {
                sh 'rm -rf Pet_Clinic-lab-11'
                sh 'git clone https://github.com/brui4n/Pet_Clinic-lab-11.git'
            }
        }
        stage('Compile') {
            steps {
                dir('Pet_Clinic-lab-11') {
                    sh 'mvn clean compile'
                }
            }
        }
        stage('Test') {
            steps {
                dir('Pet_Clinic-lab-11') {
                    withCredentials([usernamePassword(credentialsId: 'DB_CREDENTIALS', usernameVariable: 'DB_USERNAME', passwordVariable: 'DB_PASSWORD')]) {
                        sh """
                        export DB_USERNAME=${DB_USERNAME}
                        export DB_PASSWORD=${DB_PASSWORD}
                        mvn test -Dspring.profiles.active=test 
                        """
                    }
                }
            }
        }
    }
}

