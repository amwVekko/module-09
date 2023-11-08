def buildJar() {
    echo 'building application'
    sh 'mvn package'
}

def buildImg() {
    echo 'building image'
    withCredentials([usernamePassword(credentialsId: 'dockerhub-login', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t vekko/demo-app:jma-2.0 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push vekko/demo-app:jma-2.0'
}

def deployApp() {
    echo 'deploying application'
}
return this
