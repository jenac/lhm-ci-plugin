package com.lhmtech.build.ciplugin

import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by lihe on 16-4-5.
 */
class CiPlugin implements Plugin<Project> {
    void apply(Project project) {
        project.extensions.create 'gitWrapper', GitWrapper
        project.tasks.create 'increaseBuild', IncreaseBuildTask
        project.tasks.create 'gitCommitBuildFile', GitCommitBuildFileTask
        project.tasks.create 'gitPush', GitPushTask
    }
}

class IncreaseBuildTask extends  DefaultTask {

}
