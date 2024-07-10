package org.example.attackinfosender.utility;

import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class HttpClientUtil {

    private final HttpClient httpClient;

    public HttpClientUtil() {
        this.httpClient = HttpClient.newHttpClient();
    }
    public void sendPostRequest(String targetUrl, String jsonPayload) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(targetUrl))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        int responseCode = response.statusCode();
        System.out.println("Response Code: " + responseCode);
        System.out.println("Response Body: " + response.body());
    }
}

