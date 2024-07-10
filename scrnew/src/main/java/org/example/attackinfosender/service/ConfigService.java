package org.example.attackinfosender.service;

import org.example.attackinfosender.utility.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigService {

    @Autowired
    private HttpClientUtil httpClient;
    private static final String FASTAPI_URL = "http://127.0.0.1:8000/receive-config";
    private static final String BASE_URL = "http://127.0.0.1:8080/WebGoat/";
    private static final String USERNAME = "sbombatkar";
    private static final String PASSWORD = "Sneha#1234";
    private static final String VULNERABLE_URL = "http://127.0.0.1:8080/WebGoat/SqlInjectionAdvanced/attack6a";
    private static final String SESSION_URL = "http://127.0.0.1:8080/WebGoat/SqlInjectionAdvanced.lesson.lesson";

    public String sendConfig() {
        try {
            String jsonPayload = String.format(
                    "{\"base_url\":\"%s\",\"username\":\"%s\",\"password\":\"%s\",\"vulnerable_url\":\"%s\",\"session_url\":\"%s\"}",
                    BASE_URL, USERNAME, PASSWORD, VULNERABLE_URL, SESSION_URL
            );
            httpClient.sendPostRequest(FASTAPI_URL, jsonPayload);
            return "Configuration sent successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to send configuration.";
        }
    }
}
