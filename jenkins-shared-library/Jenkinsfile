#!/user/bin/env groovy
// @Library('jenkins-shared-library') refrence to global lib
library identifier: "jenkins-shared-library@main", retriever: modernSCM(
        [$class: 'GitSCMSource',
        remote: https://github.com/amwVekko/module-08/tree/main/jenkins-shared-library.git ]
        credentialsId: 'github-login']
)


def gv

pipeline {
    agent any 
    tools {
        maven 'maven-3.9'
    }

    stages {
        stage("init") {
            steps {
                script {
                    gv = "script.groovy"
                }
            }
        }

        stage('Build jar') {
            steps {
                script{
                    buildJar()
                }
            }
        }

        stage('build and push image') {
            steps {
                script{
                    buildImg 'vekko/demo-app:jma-3.0'
                    dockerLogin
                    dockerPush 'vekko/demo-app:jma-3.0'
                }
                }
            }
        }

        stage('Deploy') {
            steps {
                script{
                    gv.deployApp
                }
            }
        }
    }
}