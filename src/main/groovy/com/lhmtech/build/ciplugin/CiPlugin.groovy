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
        project.tasks.create 'gitCommitBuildFile', GitCommitBuildFileTask
        project.tasks.create 'gitPush', GitPushTask
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

class GitPushTask extends DefaultTask {
    @TaskAction
    void gitPush() {
        GitWrapper gitWrapper = new GitWrapper()
        gitWrapper.push()
    }
}

class GitCommitBuildFileTask extends DefaultTask {
    @TaskAction
    void gitCommitBuildFile() {
        GitWrapper gitWrapper = new GitWrapper()
        gitWrapper.commit 'build: increase build number'
    }
}