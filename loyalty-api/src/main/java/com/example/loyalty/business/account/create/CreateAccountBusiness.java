package com.example.loyalty.business.account.create;

import com.example.loyalty.account.AccountDto;
import com.example.loyalty.account.AccountServiceGrpc;
import com.example.loyalty.account.CreateAccountRequest;
import com.example.loyalty.account.GENDER;
import com.example.loyalty.business.account.create.dto.CreateResponse;
import com.example.loyalty.business.account.create.dto.CreateRequest;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CreateAccountBusiness implements ICreateAccount{

    @GrpcClient("account-service")
    private AccountServiceGrpc.AccountServiceBlockingStub accountBlockingStub;

    @Override
    public CreateResponse createAccount(CreateRequest request) {
        CreateAccountRequest createAccountRequest = CreateAccountRequest.newBuilder()
                .setName(request.getName())
                .setAddress(request.getAddress())
                .setPhoneNumber(request.getPhoneNumber())
                .setEmail(request.getEmail())
                .setGender(GENDER.valueOf(request.getGender().toUpperCase()))
                .setIsActive(true)
                .build();
        AccountDto accountDto = this.accountBlockingStub.createAccount(createAccountRequest);
        CreateResponse response = CreateResponse.builder()
                .name(accountDto.getName())
                .phoneNumber(accountDto.getPhoneNumber())
                .email(accountDto.getEmail())
                .address(accountDto.getAddress())
                .build();
        return response;
    }
}
