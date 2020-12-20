package com.myDiary;

import java.time.LocalDateTime;

public class UserEntry {
    private String entryTitle;
    private LocalDateTime entryDateAndTime;
    private String entryBody;

    public UserEntry(String userEntryTitle) {
        entryTitle = userEntryTitle;
        entryDateAndTime = LocalDateTime.now();
    }

    public String getEntryTitle() {
        return entryTitle;
    }

    public LocalDateTime getEntryDateAndTime() {
    return entryDateAndTime;
    }

    public void updateEntryTitle(String newEntryTitle) {
            entryTitle = newEntryTitle;

    }

    public void updateEntryBody(String newEntryBody) {
        entryBody = newEntryBody;
    }

    public String getEntryBody() {
        return entryBody;
    }
}
