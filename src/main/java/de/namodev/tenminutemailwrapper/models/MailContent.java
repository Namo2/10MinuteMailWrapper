package de.namodev.tenminutemailwrapper.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MailContent {
    @JsonProperty("from")
    private String from;

    @JsonProperty("to")
    private String to;

    @JsonProperty("gravatar")
    private String avatar;

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("datetime")
    private String dateTime;

    @JsonProperty("datetime2")
    private String dateTime2;

    @JsonProperty("timestamp")
    private int timestamp;

    @JsonProperty("urls")
    private String[] urls;

    @JsonProperty("html")
    private String[] html;

    @JsonProperty("plain")
    private String[] plain;

    @JsonProperty("plain_link")
    private String[] plainLink;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String[] getUrls() {
        return urls;
    }

    public void setUrls(String[] urls) {
        this.urls = urls;
    }

    public String[] getHtml() {
        return html;
    }

    public void setHtml(String[] html) {
        this.html = html;
    }

    public String[] getPlain() {
        return plain;
    }

    public void setPlain(String[] plain) {
        this.plain = plain;
    }

    public String[] getPlainLink() {
        return plainLink;
    }

    public void setPlainLink(String[] plainLink) {
        this.plainLink = plainLink;
    }

    public MailContent() {
    }

    public MailContent(String from, String to, String avatar, String subject, String dateTime, String dateTime2, int timestamp, String[] urls, String[] html, String[] plain, String[] plainLink) {
        this.from = from;
        this.to = to;
        this.avatar = avatar;
        this.subject = subject;
        this.dateTime = dateTime;
        this.dateTime2 = dateTime2;
        this.timestamp = timestamp;
        this.urls = urls;
        this.html = html;
        this.plain = plain;
        this.plainLink = plainLink;
    }
}
