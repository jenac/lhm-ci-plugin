Setup artifactory server with docker
================================

## Install docker
refer the [Ubuntu Development Environment Setup](https://bitbucket.org/healthsource/healthsource/wiki/Ubuntu_Dev_Env_Setup)

## Pull docker image 
refer [jfrog document](https://www.jfrog.com/confluence/display/RTF/Running+with+Docker)
```
docker pull jfrog-docker-reg2.bintray.io/jfrog/artifactory-oss
```

## Run artifactory docker container
```
docker run --name artifactory-ci -p 8081:8081 -d jfrog-docker-reg2.bintray.io/jfrog/artifactory-oss
```
Some tips:

* To start docker container
```
docker start artifactory-ci
```

* To stop docker container
```
docker stop artifactory-ci
```

* Attach to container with bash interactively
```
docker exec -i -t artifactory-ci bash
``` 

## Using systemd to start/stop container with Linux
```
cd /etc/init
sudo nano artifactory-ci.conf
```
Put the following:
```
description "artifactory-ci daemon"

start on filesystem and started docker
stop on runlevel [!2345]

respawn

script
        /usr/bin/docker start -a artifactory-ci
end script
```

## Login to artifactory for the first time
```
Username: admin
Password: password
```