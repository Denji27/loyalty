package com.example.loyalty.controller;

import com.example.loyalty.account.AccountDto;
import com.example.loyalty.account.AccountServiceGrpc;
import com.example.loyalty.account.CreateAccountRequest;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account-service")
public class controller {
    @GrpcClient("account-service-test")
    private AccountServiceGrpc.AccountServiceBlockingStub accountBlockingStub;
    @PostMapping
    ResponseEntity<?> createAccount(@RequestBody CreateRequest createRequest){
        CreateAccountRequest createAccountRequest = CreateAccountRequest.newBuilder()
                .setName(createRequest.getName())
                .setAddress(createRequest.getAddress())
                .setPhoneNumber(createRequest.getPhoneNumber())
                .setEmail(createRequest.getEmail())
                .setIsActive(true)
                .build();
        AccountDto accountDto = this.accountBlockingStub.createAccount(createAccountRequest);
        CreateResponse response = CreateResponse.builder()
                .name(accountDto.getName())
                .phoneNumber(accountDto.getPhoneNumber())
                .email(accountDto.getEmail())
                .address(accountDto.getAddress())
                .build();
        return ResponseEntity.ok(response);
    }
}
