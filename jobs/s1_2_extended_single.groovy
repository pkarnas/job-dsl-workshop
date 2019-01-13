import javaposse.jobdsl.dsl.helpers.publisher.PublisherContext

job('job 2 sample-gradle-build') {
    wrappers {
        timestamps()
    }
    scm {
        github('pkarnas/sample1-gradle-ci', 'master')
    }
    triggers {
        scm("@midnight")
        cron("0 5 * * 1")
    }
    steps {
        gradle('clean check', null, true)
    }
    publishers {
        archiveJunit('**/target/surefire-reports/*.xml'){
            allowEmptyResults(true)
        }
    }
}
