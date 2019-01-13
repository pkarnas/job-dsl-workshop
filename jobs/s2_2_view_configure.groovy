listView('seeds-last') {
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
    }
    configure { Node node ->
        node / 'columns' << 'com.robestone.hudson.compactcolumns.AllStatusesColumn' {
            colorblindHint('nohint')
            timeAgoTypeString('DIFF')
            onlyShowLastStatus('false')
            hideDays('0')
        }
    }
    columns {
        buildButton()
        lastBuildConsole()
    }
}