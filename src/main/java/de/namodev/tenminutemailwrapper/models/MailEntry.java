package de.namodev.tenminutemailwrapper.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MailEntry {
    @JsonProperty("mail_id")
    private String mailId;

    @JsonProperty("from")
    private String from;

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("datetime")
    private String dateTime;

    @JsonProperty("datetime2")
    private String dateTime2;

    @JsonProperty("timeago")
    private int timeAgo;

    @JsonProperty("isread")
    private String isRead;

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDateTime2() {
        return dateTime2;
    }

    public void setDateTime2(String dateTime2) {
        this.dateTime2 = dateTime2;
    }

    public int getTimeAgo() {
        return timeAgo;
    }

    public void setTimeAgo(int timeAgo) {
        this.timeAgo = timeAgo;
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

    public MailEntry() {}

    public MailEntry(String mailId, String from, String subject, String dateTime, String dateTime2, int timeAgo, String isRead) {
        this.mailId = mailId;
        this.from = from;
        this.subject = subject;
        this.dateTime = dateTime;
        this.dateTime2 = dateTime2;
        this.timeAgo = timeAgo;
        this.isRead = isRead;
    }
}
