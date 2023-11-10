#!/user/bin/env groovy
// @Library('jenkins-shared-library') refrence to global lib
library identifier: "jenkins-shared-library@main", retriever: modernSCM(
        [$class: 'GitSCMSource',
        remote: https://github.com/amwVekko/module-09/tree/main/jenkins-shared-library.git ]
        credentialsId: 'github-login']
)

pipeline {
    agent any 
    tools { 
        maven 'maven-3.9'
    }


    stages {
        stage('increment version') {
            steps {
                script {
                    echo 'incrementing version'
                    sh "mvn build-helper:parse version versions:set \
                        -DnewVersion=\\\${parsedVersion.majorVrsion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
                        -versions:commit"
                    def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
                    def version = matcher[0][1]
                    env.IMAGE_NAME = "$version-$BIULD_NUMBER"
                }
            }
        }

        stage('Build application') {
            steps {
                echo 'building application'
                buildJar()
            }
        }

        stage('build image ') {
            steps {
                echo 'building image'
                buildImg(env.IMAGE_NAME)
                dockerLogin()
                dockerPush(env.IMAGE_NAME)
                 
            }
        }

        stage('Deploy') {
            steps {
                script {
                    def shellCmd = "bash ./servercmd.sh ${IMAGE_NAME}"
                    def ec2Instance = "ec2-user@18.196.64.3"
                    sshagent(['ec2-key'])
                        sh "scp servercmd.sh ${ec2Instance}:/home/ec2-user/"
                        sh "scp docker-compose.yml e${ec2Instance}:/home/ec2-user/"
                        sh "ssh -o StrictHostKeyChecking=no ${ec2Instance} ${shellCmd}"
                }
            }
        }
        stage('commit version update'){
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'gitlab-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]){
                        sh 'git remote set-url origin https://$USER:$PASS@gitlab.com/twn-devops-bootcamp/latest/09-AWS/java-maven-app.git'
                        sh 'git add .'
                        sh 'git commit -m "ci: version bump"'
                        sh 'git push origin HEAD:jenkins-jobs'

    }
}