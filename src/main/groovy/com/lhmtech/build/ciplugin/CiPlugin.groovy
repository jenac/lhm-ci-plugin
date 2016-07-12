package com.lhmtech.build.ciplugin

import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.TaskAction

/**
 * Created by lihe on 16-4-5.
 */
class CiPlugin implements Plugin<Project> {
    void apply(Project project) {
        project.extensions.create 'buildVersionManager', BuildVersionManager
        project.tasks.create 'increaseBuild', IncreaseBuildTask
    }
}

class IncreaseBuildTask extends  DefaultTask {
    @TaskAction
    void increaseBuild() {
        BuildVersionManager buildVersionManager = project.extensions.buildVersionManager
        println 'current version: ' + buildVersionManager.readBuild()
        buildVersionManager.increaseBuild()
        println 'increased version: ' + buildVersionManager.readBuild()
    }
}

class PrintBuildTask extends DefaultTask {
    @TaskAction
    void printBuild() {
        BuildVersionManager buildVersionManager = project.extensions.buildVersionManager
        println buildVersionManager.readBuild()
    }
}
