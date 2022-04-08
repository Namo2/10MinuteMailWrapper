package de.namodev.tenminutemailwrapper;

import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public record HttpRequestHelper(HttpClient httpClient, String baseUrl) {
    public Optional<HttpResponse<String>> sendHttpRequest(String urlPath) {
        HttpRequest request = buildHttpRequest(urlPath);

        try {
            return Optional.of(httpClient.send(request, HttpResponse.BodyHandlers.ofString()));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public CompletableFuture<HttpResponse<String>> sendHttpRequestAsync(String urlPath) {
        HttpRequest request = buildHttpRequest(urlPath);

        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
    }

    public HttpRequest buildHttpRequest(String urlPath) {
        return HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(baseUrl + urlPath))
                .build();
    }
}
