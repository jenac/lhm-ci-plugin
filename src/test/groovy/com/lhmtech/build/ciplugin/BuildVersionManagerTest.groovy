package com.lhmtech.build.ciplugin

import org.junit.Ignore
import spock.lang.Specification

/**
 * Created by lihe on 16-4-5.
 */
@Ignore
class BuildVersionManagerTest extends Specification {
    def "IncreaseBuild"() {
        given:
        BuildVersionManager buildVersionManager = new BuildVersionManager()
        when:
        buildVersionManager.increaseBuild()
        then:
        true


    }
}
