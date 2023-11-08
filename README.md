# modul-08
Build Automation &amp; CI/CD with Jenkins


Install Jenkins
1. started jenkins container locally on proxmoxhost. please see jenkins-task.yml and jenkins.yml
2. also created docker network "devops" for easier access between jenkins and nexus container
3. jenkins available at IP:8080
4. added maven in tools. installed nodejs plugin
5. docker exec -u 0 -it jenkins /bin/bash to get root access and installed nodejs

--------------------------------------------------

Jenkins Basics Demo
1. created test-freestyle-job
2. added build step shell command npm --version
3. added stet maven goals --version
4. configured nodejs in tools
5. added gitlab credentials and URL to freestylejob and ran it
6. created new freestyle job to build the java applications


--------------------------------------------------

Docker in Jenkins
1. docker.sock is already mounted, as can be seen in the jenkins-task.yml
2. curl https://get.docker.com/ > dockerinstall && chmod 777 dockerinstall && ./dockerinstall
3. chmod 666 /var/run/docker.sock
4. pulled redis image in jenkins container as jenkins user
5. changed job to build the image
6. tail output of console:
sha256:7bc6730ac574ff26111fadf0ab0a41fb9bf433153eea29706578bbcb058acaf7 done
#8 naming to docker.io/library/java-maven-app:1.0 done
#8 DONE 0.1s
Finished: SUCCESS
7. created private bootcamp repo on dockerhub
8. added docker credentials in jenkins
9. edited job to login to docker with secret text
10. edited job to push to dockerhub. built job. checked dockerhub, image is available
11. added nexus login credentials in jenkins
12. edited job to use nexus repo and ran job successfully

--------------------------------------------------

Intro to pipeline job
1. Used SCM definition, used Git with gitlab credentials added git url
2. added a jenkinsfile as a template
3. configured and tested some parameters
4. added script.groovy to use in jenkinsfile
5. build with parameters
6. added userinput to pipeline
7. build with parameters and choosed env in deployment stage
8. same test with two environments

--------------------------------------------------

create complete pipeline
1. moved jenkinsfile from previous section to "jenkinsfile_syntax"
2. created new jenkinsfile, added tools "maven-3.9"
3. added steps to build and push image to docker
4. added new groovyscript and moved steps in it. defined groovy script in jenkinsfile

--------------------------------------------------

Multibranch pipeline
1. added multibranch pipeline and scanned for all branches
2. added when condition to just build if branch = master


--------------------------------------------------


Jenkins Shared Library
Starting code: https://gitlab.com/twn-devops-bootcamp/latest/08-jenkins/jenkins-shared-library/-/tree/starting-code
Final code: https://gitlab.com/twn-devops-bootcamp/latest/08-jenkins/jenkins-shared-library

1. created new project "jenkins-shared-library"
2. 





--------------------------------------------------


Reference: DevOps Bootcamp and TWN