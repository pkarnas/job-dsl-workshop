listView('seeds') {
    jobs {
        regex(/.*-seed/)
    }
    columns {
        status()
        weather()
        name()
        lastSuccess()
        lastFailure()
        lastDuration()
        buildButton()
    }
}