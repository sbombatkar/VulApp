package org.example.attackinfosender.controller;

import org.example.attackinfosender.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ConfigController {

    @Autowired
    private ConfigService configService;

    @PostMapping("/send-config")
    public ResponseEntity<String> sendConfig(@RequestBody Map<String, String> requestBody) {
        String appName = requestBody.get("appName");
        String attackType = requestBody.get("attackType");

        if ("webgoat".equalsIgnoreCase(appName) && "sql injection".equalsIgnoreCase(attackType)) {
            return ResponseEntity.ok(configService.sendConfig());
        } else {
            return ResponseEntity.badRequest().body("Invalid application name or attack type.");
        }
    }
}

