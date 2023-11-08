pipeline {
    agent any 
    tools {
        maven 'maven-3.9'
    }

    stages {
        stage('Build jar') {
            steps {
                echo 'building application'
                sh 'mvn package'
            }
        }


        stage('build image') {
            steps {
                echo 'building image'
                withCredentials([usernamePassword(credentialsId: 'dockerhub-login', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                    sh 'docker build -t vekko/demo-app:jma-2.0 .'
                    sh 'echo $PASS | docker login -u $USER --password-stdin'
                    sh 'docker push vekko/demo-app:jma-2.0'
                }
            }
        }


        stage('Deploy') {
            steps {
                echo 'deploying application'
                // code here
            }
        }
    }
}