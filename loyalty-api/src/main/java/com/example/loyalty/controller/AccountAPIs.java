package com.example.loyalty.controller;

import com.example.loyalty.business.account.create.dto.CreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.CacheRequest;

@RequestMapping("account")
public interface AccountAPIs {
    @PostMapping
    ResponseEntity<?> createAccount(@RequestBody CreateRequest createRequest);
}
