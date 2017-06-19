import groovy.json.JsonSlurper

URL reposRestEndpoint = "https://api.github.com/users/solidsoft-training/repos".toURL()
String reposAsJson = reposRestEndpoint.text
List parsedRepos = (List) new JsonSlurper().parseText(reposAsJson)  //a combination of lists and maps

parsedRepos.each { Map project ->

    if (project.name.endsWith("-gradle-ci")) {

        job(project.name) {
            wrappers {
                timestamps()
            }
            scm {
                git project.git_url
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
    }
}
