## Workshop project

This project is built with [Gradle](https://gradle.org/). However thanks to the usage of a wrapper there is no need to have it installed prior
to the building process.

Simple compilation with tests execution

    ./gradlew check

(`gradlew.bat` instead of `./gradlew` on Windows)


IntelliJ Idea import: `File -> Import Project.`


Eclipse import:

    ./gradlew eclipse

(on Windows double click `gradlew-eclipse.bat`)

and later: `File -> Import -> Existing Project Into Workspace`

### File structure

    .
    ├── jobs                    # DSL script files
    ├── resources               # resources for DSL scripts (optional)
    ├── src
    │   ├── main
    │   │   ├── groovy          # support classes
    │   │   └── resources
    │   │       └── idea.gdsl   # IDE support for IDEA
    │   └── test
    │       └── groovy          # specs
    └── build.gradle            # build file
