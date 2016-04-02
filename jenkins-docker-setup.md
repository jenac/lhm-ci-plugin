Setup jenkins server with docker
================================

##install docker
refer the https://bitbucket.org/healthsource/healthsource/wiki/Ubuntu_Dev_Env_Setup

##pull docker image
```
docker pull jenkins
```

##run jenkins docker container
Prepare local volume /home/lihe/jenkins_data, then
```
docker run -p 8080:8080 -p 5000:5000 -v /home/lihe/jenkins_data:/var/jenkins_home --name jenkins-ci -d jenkins
```
Some tips:
1. To start docker container
```
docker start jenkins-ci
```

2.

