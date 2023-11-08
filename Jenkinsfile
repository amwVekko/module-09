pipeline {
    agent any 

    stages {
        stage('Test') {
            steps {
                echo 'testing application'
                echo "executing pipeline for branch $BRANCH_NAME"
            }
        }


        stage('Build') {
            when {
                BRANCH_NAME == "master" //main for github
            }
            steps {
                echo 'building application'
                // code here
            }
        }



        stage('Deploy') {
            when {
                BRANCH_NAME == "master" //main for github
            }
            steps {
                echo 'deploying application'
                // code here
            }
        }
    }
}