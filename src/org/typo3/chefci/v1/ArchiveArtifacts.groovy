#!/usr/bin/env groovy

package org.typo3.chefci.v1;

def archiveArtifacts(){
    def artifactName = "cookbooks-${env.BUILD_TAG}.tar.gz"
    echo "Skipping to archive complete cookooks, as long as we have private data in some cookbooks... :-/"
    // sh("berks package ${artifactName}")
    // archive(includes: artifactName)

    echo "Archiving test-kitchen logs"
    archive(includes: ".kitchen/logs/*")
}

def execute(){
    stage('archive artifacts')
    node {
        this.archiveArtifacts()
    }
}

return this;
