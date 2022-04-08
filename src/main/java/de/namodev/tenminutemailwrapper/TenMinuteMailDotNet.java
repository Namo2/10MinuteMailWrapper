package de.namodev.tenminutemailwrapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.namodev.tenminutemailwrapper.models.MailContent;
import de.namodev.tenminutemailwrapper.models.MailResponse;

import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class TenMinuteMailDotNet {
    private static final String URL_RESET_10 = "more.html";
    private static final String URL_RESET_100 = "more100.html";
    private static final String URL_NEW = "new.html";
    private static final String URL_RECOVER = "recover.html";
    private static final String URL_GET_MAIL = "address.api.php";
    private static final String URL_GET_MAIL_CONTENT = "mail.api.php?mailid=";
    private static final String BASE_URL = "https://10minutemail.net/";

    private final HttpRequestHelper requestHelper;
    private final CookieStore cookieStore;

    public TenMinuteMailDotNet() {
        CookieHandler.setDefault(new CookieManager());

        cookieStore = ((CookieManager) CookieHandler.getDefault())
                .getCookieStore();

        HttpClient httpClient = HttpClient.newBuilder()
                .cookieHandler(CookieHandler.getDefault())
                .build();

        requestHelper = new HttpRequestHelper(httpClient, BASE_URL);
    }

    public MailResponse getEmail() {
        Optional<HttpResponse<String>> httpResponse = requestHelper.sendHttpRequest(URL_GET_MAIL);

        if (httpResponse.isEmpty())
            return null;

        HttpResponse<String> stringHttpResponse = httpResponse.get();
        saveLatestCookies(stringHttpResponse);

        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(stringHttpResponse.body(), MailResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void generateNewEmailAddress() {
        requestHelper.sendHttpRequest(URL_NEW)
                .ifPresent(this::saveLatestCookies);
    }

    public void recoverLastEmailAddress() {
        requestHelper.sendHttpRequest(URL_RECOVER)
                .ifPresent(this::saveLatestCookies);
    }

    public void resetTo10Minutes() {
        requestHelper.sendHttpRequest(URL_RESET_10)
                .ifPresent(this::saveLatestCookies);
    }

    public void resetTo100Minutes() {
        requestHelper.sendHttpRequest(URL_RESET_100)
                .ifPresent(this::saveLatestCookies);
    }

    public MailContent getMailContent(String mailId) {
        String mailIdSafe = URLEncoder.encode(mailId, StandardCharsets.UTF_8);

        Optional<HttpResponse<String>> httpResponse = requestHelper.sendHttpRequest(URL_GET_MAIL_CONTENT + mailIdSafe);

        if (httpResponse.isEmpty())
            return null;

        HttpResponse<String> stringHttpResponse = httpResponse.get();
        saveLatestCookies(stringHttpResponse);

        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(stringHttpResponse.body(), MailContent.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }

    public MailContent getLastEmailContent() {
        MailResponse mailResponse = getEmail();
        if (mailResponse == null || mailResponse.getMailList().length < 1)
            return null;

        return getMailContent(mailResponse.mailList[0].getMailId());
    }

    private void saveLatestCookies(HttpResponse<String> response) {
        response.headers().allValues("set-cookie").forEach(cookie -> {
            String[] cookiesParts = cookie.split(";");

            try {
                String[] cookieValues = cookiesParts[0].split("=");
                HttpCookie newCookie = new HttpCookie(cookieValues[0], cookieValues[1]);

                cookieStore.add(new URI(BASE_URL), newCookie);
            } catch (URISyntaxException | ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        });
    }
}
