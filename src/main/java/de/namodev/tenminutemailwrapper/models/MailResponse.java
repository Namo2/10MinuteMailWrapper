package de.namodev.tenminutemailwrapper.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MailResponse {
    @JsonProperty("mail_get_user")
    private String user;

    @JsonProperty("mail_get_mail")
    private String address;

    @JsonProperty("mail_get_host")
    private String host;

    @JsonProperty("mail_get_time")
    public int time;

    @JsonProperty("mail_get_duetime")
    public int dueTime;

    @JsonProperty("mail_server_time")
    public int serverTime;

    @JsonProperty("mail_get_key")
    public String mailKey;

    @JsonProperty("mail_left_time")
    public int timeLeft;

    @JsonProperty("mail_recovering_key")
    public String recoveringKey;

    @JsonProperty("mail_recovering_mail")
    public String recoverableMailAddress;

    @JsonProperty("session_id")
    public String sessionId;

    @JsonProperty("mail_list")
    public MailEntry[] mailList;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getDueTime() {
        return dueTime;
    }

    public void setDueTime(int dueTime) {
        this.dueTime = dueTime;
    }

    public int getServerTime() {
        return serverTime;
    }

    public void setServerTime(int serverTime) {
        this.serverTime = serverTime;
    }

    public String getMailKey() {
        return mailKey;
    }

    public void setMailKey(String mailKey) {
        this.mailKey = mailKey;
    }

    public int getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }

    public String getRecoveringKey() {
        return recoveringKey;
    }

    public void setRecoveringKey(String recoveringKey) {
        this.recoveringKey = recoveringKey;
    }

    public String getRecoverableMailAddress() {
        return recoverableMailAddress;
    }

    public void setRecoverableMailAddress(String recoverableMailAddress) {
        this.recoverableMailAddress = recoverableMailAddress;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public MailEntry[] getMailList() {
        return mailList;
    }

    public void setMailList(MailEntry[] mailList) {
        this.mailList = mailList;
    }

    public MailResponse() {}

    public MailResponse(String user, String address, String host, int time, int dueTime, int serverTime, String mailKey, int timeLeft, String recoveringKey, String recoverableMailAddress, String sessionId, MailEntry[] mailList) {
        this.user = user;
        this.address = address;
        this.host = host;
        this.time = time;
        this.dueTime = dueTime;
        this.serverTime = serverTime;
        this.mailKey = mailKey;
        this.timeLeft = timeLeft;
        this.recoveringKey = recoveringKey;
        this.recoverableMailAddress = recoverableMailAddress;
        this.sessionId = sessionId;
        this.mailList = mailList;
    }
}
