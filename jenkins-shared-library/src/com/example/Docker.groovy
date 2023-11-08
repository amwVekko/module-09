#!/user/bin/env groovy
package com.example

class Docker implements Serializable{

    def script

    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName) {
        script.echo 'building image'
        script.sh "docker build -t $imageName ."
            
        
    }

    def dockerLogin() {
        script.withCredentials([usernamePassword(credentialsId: 'dockerhub-login', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh "echo '${script.PASS' | docker login -u $'{script.USER}' --password-stdin"
            script.sh "docker push $imageName"
    }

    def dockerPush(String imageName) {
        script.sh "docker push $imageName"
    }
}
