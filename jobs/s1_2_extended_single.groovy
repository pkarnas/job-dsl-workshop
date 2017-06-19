
job('sample-gradle-build') {
    wrappers {
        timestamps()
    }
    scm {
        git('https://github.com/solidsoft-training/sample1-gradle-ci.git', 'master')
    }
    triggers {
        scm '@midnight'
        cron 'H 6 * * 1'
    }
    steps {
        gradle 'clean check'
    }
    publishers {
        archiveJunit('**/build/test-results/**/*.xml') {
            allowEmptyResults()
        }
    }
}
