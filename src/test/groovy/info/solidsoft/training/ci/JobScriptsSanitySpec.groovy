package info.solidsoft.training.ci

import groovy.io.FileType
import javaposse.jobdsl.dsl.DslScriptLoader
import javaposse.jobdsl.dsl.MemoryJobManagement
import spock.lang.Specification

/**
 * Tests that all dsl scripts in the jobs directory will compile.
 */
class JobScriptsSanitySpec extends Specification {

//    @Unroll   //unroll not needed anymore thanks to spock-global-unroll
    void "script '#file.name' should compile"() {
        given:
            MemoryJobManagement jobManagement = new MemoryJobManagement()
            DslScriptLoader dslScriptLoader = new DslScriptLoader(jobManagement)
        when:
            dslScriptLoader.runScript(file.text)
        then:
            noExceptionThrown()
        where:
            file << jobFiles
    }

    private List<File> getJobFiles() {
        List<File> jobScripts = []
        new File('jobs').eachFileRecurse(FileType.FILES) {
            jobScripts << it
        }
        return jobScripts
    }
}
