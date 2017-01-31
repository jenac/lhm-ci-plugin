package com.lhmtech.ci.plugin

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
        project.tasks.create 'deployBuild', DeployBuild
    }
}


