
listView('seeds2') {
    jobFilters {
        regex {
            regex '^.*-seed\$'
        }
    }
    columns {
        status()
        weather()
        name()
        lastSuccess()
        lastFailure()
        lastDuration()
    }
}
