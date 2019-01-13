import groovy.json.JsonSlurper

def repos = new JsonSlurper().parse('https://api.github.com/users/solidsoft-training/repos'.toURL())

repos.findAll({ it.full_name.startsWith('solidsoft-training') && it.full_name.endsWith('-gradle-ci') })
        .each { repo ->
    job("job 3") {
        scm {
            github('pkarnas/sample1-gradle-ci', 'master')
        }
        triggers {
            scm("@midnight")
            scm("0 5 * * 1")
        }

        steps {
            gradle('clean check', null, true)
        }
        steps {
            wrappers {
                timestamps()
            }
        }
        publishers {
            archiveJunit('**/target/surefire-reports/*.xml'){
                allowEmptyResults(true)
            }
        }
    }
}