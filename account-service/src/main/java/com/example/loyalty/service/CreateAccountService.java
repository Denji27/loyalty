package com.example.loyalty.service;

import com.example.loyalty.account.AccountDto;
import com.example.loyalty.account.AccountServiceGrpc;
import com.example.loyalty.account.CreateAccountRequest;
import com.example.loyalty.entity.account.Account;
import com.example.loyalty.repository.AccountRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class CreateAccountService extends AccountServiceGrpc.AccountServiceImplBase {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void createAccount(CreateAccountRequest request, StreamObserver<AccountDto> responseObserver) {
        Account account = Account.builder()
                .name(request.getName())
                .address(request.getAddress())
                .phoneNumber(request.getPhoneNumber())
                .email(request.getEmail())
                .gender(request.getGender().toString())
                .isActive(request.getIsActive())
                .build();
        AccountDto accountDto = AccountDto.newBuilder()
                .setName(request.getName())
                .setAddress(request.getAddress())
                .setEmail(request.getEmail())
                .setPhoneNumber(request.getPhoneNumber())
                .build();
        this.accountRepository.save(account);
        responseObserver.onNext(accountDto);
        responseObserver.onCompleted();
    }
}
