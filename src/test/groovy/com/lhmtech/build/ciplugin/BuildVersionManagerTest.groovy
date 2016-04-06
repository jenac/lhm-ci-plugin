package com.lhmtech.build.ciplugin

import org.junit.Ignore
import spock.lang.Specification

/**
 * Created by lihe on 16-4-5.
 */
class BuildVersionManagerTest extends Specification {
    def "build version manager increase build"() {
        given:
        BuildVersionManager buildVersionManager = new BuildVersionManager()
        File file = new File(buildVersionManager.buildFile)
        file.write "info.app.version=1.0.8"

        when:
        String current = buildVersionManager.readBuild()
        buildVersionManager.increaseBuild()
        String increased = buildVersionManager.readBuild()

        then:
        current == '1.0.8'
        increased == '1.0.9'


    }
}
