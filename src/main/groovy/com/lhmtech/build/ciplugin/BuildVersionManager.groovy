package com.lhmtech.build.ciplugin

/**
 * Created by lihe on 16-4-5.
 */
class BuildVersionManager {
    String buildFile = 'src/main/resources/build.properties'
    File propertyFile = new File(buildFile)

    void increaseBuild() {
        def currentVersion = readBuild()

        def parts = currentVersion.tokenize '.'
        def newBuildNumber = parts.last().toInteger() + 1
        def increasedParts = parts.dropRight(1)
        increasedParts.add(newBuildNumber)
        String newVersion = increasedParts.join '.'
        Properties properties = new Properties()
        properties.setProperty('info.app.version', newVersion)
        properties.store propertyFile.newWriter(), null
    }

    String readBuild() {
        def stream = propertyFile.newDataInputStream()
        Properties properties = new Properties()
        properties.load(stream)
        String currentVersion = properties.getProperty('info.app.version')
    }


}
