
listView('fancy-seeds') {
    jobFilters {
        regex {
            regex '^.*-seed\$'
        }
    }
    columns {
        status()
        weather()
        name()
    }
    configure compactColumns()
    columns {
        lastDuration()
        buildButton()
        lastBuildConsole()
        cronTrigger()
    }
}

private static Closure compactColumns() {
    return { Node listViewNode ->    //Replace with native support for Compact Columns when available
        listViewNode / 'columns' << 'com.robestone.hudson.compactcolumns.AllStatusesColumn' {
            colorblindHint('nohint')
            timeAgoTypeString('DIFF')
            onlyShowLastStatus(false)
            hideDays(0)
        }
    }
}
