# modul-09
AWS Services

1. created Account
2. created admin IAM user, logged in, changed password


--------------------------------------------------

Intro to EC2

1. launched free tier EC2 with new created key pair
2. moved .pem to local .ssh folder
3. chmod 400 "filename".pem
4. tested ssh connection with -i .pem file and ec2-user@"IPv4"
5. installed docker "sudo yum install docker -y"
5. started docker daemon "sudo systemctl restart docker.service"
6. added ec2-user to docker group "sudo usermod -aG ec2-user
7. relogged in and tested "docker pull redis"
8. logged in to docker
9. build docker image and pushed to dockerhub. even if i logged in before, i needed to docker logout and login again to be able to push
10. pulled docker image on EC2 
11. "docker run -d -p 3000:3080 vekko/demo-app:rne-1.0"
12. opened port 3000 to make app available from outside

--------------------------------------------------

Deploy EC2 from jenkins pipeline

1. Cloned java-maven-app
2. installed ssh agent plugin in jenkins
3. created credentials to be able to login to EC2 with ssh
4. checked out pipeline syntax in jenkins
5. created new jenkinsfile and added sshagent and dockerun command
6. in the meantime i installed docker locally on my private promox host, so no new ssh port needed to open (needed if jenkins runs on digitalOcean)
7. built pipeline
8. updated jenkinsfile with shared library
9. built pipeline

Part 2

1. installed docker-compose on EC2
2. created docker-compose.yml
3. added servercmd.sh 
4. built pipeline

Part 3

1. 



--------------------------------------------------

Reference: DevOps Bootcamp and TWN