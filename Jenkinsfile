#!/usr/bin/env/groovy
node {
    stage('Checkout') {
        git 'https://github.com/lhmtech/lhmtech-ci-plugin.git'
    }
    stage('Build') {
        sh './gradlew clean build'
    }
}