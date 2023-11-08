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
                    gv.buildJar()
                }
            }
        }


        stage('build image') {
            steps {
                script{
                    gv.buildImg()
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