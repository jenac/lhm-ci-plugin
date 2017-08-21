#!/usr/bin/env/groovy
node {
    stage('Checkout') {
        git 'https://github.com/lhmtech/lhmtech-ci-plugin.git'
    }
    stage('Build') {
        sh './gradlew clean build'
    }
    stage('Publish') {
            sh './gradlew -PbintrayUser=${env.BINTRAY_USER} -PbintrayApiKey=${env.BINTRAY_API_KEY} bintrayUpload'
    }
}