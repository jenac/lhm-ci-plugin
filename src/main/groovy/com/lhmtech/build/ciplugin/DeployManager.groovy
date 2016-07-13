package com.lhmtech.build.ciplugin

/**
 * Created by lihe on 7/12/16.
 */
class DeployManager {
    void requestDeploy(String deployUrl, String token, String version) {
        def response = ["curl", '-X', "POST", "${deployUrl}", "--data",
                        "token=${token}", "--data-urlencode",
                        "json={\"parameter\": [{\"name\": \"VERSION\", \"value\": \"${version}\"}]}"].execute()
        response.waitForProcessOutput(System.out, System.err)
    }
}
