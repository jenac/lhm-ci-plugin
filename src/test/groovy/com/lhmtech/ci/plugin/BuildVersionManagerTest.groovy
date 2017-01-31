package com.lhmtech.ci.plugin

import spock.lang.Specification

/**
 * Created by lihe on 16-4-5.
 */
class BuildVersionManagerTest extends Specification {
    def "build version manager increase build"() {
        given:
        String otherLine = "info.app.name=some-name"
        BuildVersionManager buildVersionManager = new BuildVersionManager()
        File file = new File(buildVersionManager.buildFile)
        file.write "info.app.version=1.0.8\r\n"
        file.append otherLine

        when:
        String current = buildVersionManager.readBuild()
        buildVersionManager.increaseBuild()
        String increased = buildVersionManager.readBuild()
        File increasedFile = new File(buildVersionManager.buildFile)
        List<String> lines = increasedFile.readLines()

        then:
        current == '1.0.8'
        increased == '1.0.9'
        lines.contains(otherLine)


    }
}
