package com.cloud.resilientapi;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final String instanceId;

    public ApiController(@Value("${server.instance-id:local}") String instanceId) {
        this.instanceId = instanceId;
    }

    @GetMapping("/status")
    public Map<String, String> status() {
        return Map.of("status", "running", "message", "Resilient API is working");
    }

    @GetMapping("/data")
    public Map<String, String> getData() {
        return Map.of("message", "Data from resilient-api", "instance", instanceId);
    }

    @PostMapping("/data")
    public Map<String, Object> postData(@RequestBody Map<String, Object> data) {
        return Map.of("message", "Data received successfully", "instance", instanceId, "data", data);
    }
}
