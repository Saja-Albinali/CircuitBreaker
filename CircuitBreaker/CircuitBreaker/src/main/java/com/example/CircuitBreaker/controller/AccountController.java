package com.example.CircuitBreaker.controller;

import com.example.CircuitBreaker.AccountResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class AccountController {

    private final RestTemplate restTemplate;

    public AccountController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/account")
    @CircuitBreaker(name = "stockServiceCircuitBreaker", fallbackMethod = "fallbackGetAccountDetails")
    public AccountResponse getAccountDetails() {

        String stockServiceUrl = "http://localhost:8081/stock";
        String stockResponse = restTemplate.getForObject(stockServiceUrl, String.class);

        return new AccountResponse("Account details", stockResponse, "SUCCESS");
    }

    public AccountResponse fallbackGetAccountDetails(Throwable throwable) {
        return new AccountResponse("Account details", "Stock service unavailable", "FALLBACK");
    }
}
