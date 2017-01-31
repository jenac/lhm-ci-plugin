package com.lhmtech.ci.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * Created by lihe on 17-1-30.
 */

class DeployBuild extends DefaultTask {
    @TaskAction
    void printBuild() {
        String deployUrl = project.properties.deployUrl
        String token = project.properties.token
        BuildVersionManager buildVersionManager = project.extensions.buildVersionManager
        String version = buildVersionManager.readBuild()
        DeployManager deployManager =  new DeployManager()
        deployManager.requestDeploy(deployUrl, token, version)
    }
}
