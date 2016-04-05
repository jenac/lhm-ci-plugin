package com.lhmtech.build.ciplugin

import org.ajoberstar.grgit.Grgit

/**
 * Created by lihe on 16-4-5.
 */
class GitWrapper {

    Grgit repository = Grgit.open()
    void add(String file) {
        repository.add(patterns: [file])
    }

    void commit(String message) {
        repository.commit(message: message)
    }

    void pull() {
        repository.pull()
    }

    void checkout(String branch) {
        repository.checkout(branch: branch)
    }


}

