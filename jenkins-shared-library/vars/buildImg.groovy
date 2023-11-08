#!/user/bin/env groovy

def call() {
    echo 'building image'
    withCredentials([usernamePassword(credentialsId: 'dockerhub-login', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t vekko/demo-app:jma-2.0 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push vekko/demo-app:jma-2.0'
    }
}    