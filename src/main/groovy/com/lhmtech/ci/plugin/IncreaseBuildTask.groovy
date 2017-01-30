package com.lhmtech.ci.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * Created by lihe on 17-1-30.
 */
class IncreaseBuildTask extends  DefaultTask {
    @TaskAction
    void increaseBuild() {
        BuildVersionManager buildVersionManager = project.extensions.buildVersionManager
        println 'current version: ' + buildVersionManager.readBuild()
        buildVersionManager.increaseBuild()
        println 'increased version: ' + buildVersionManager.readBuild()
    }
}