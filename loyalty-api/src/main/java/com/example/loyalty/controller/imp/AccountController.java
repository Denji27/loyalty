package com.example.loyalty.controller.imp;

import com.example.loyalty.business.account.create.ICreateAccount;
import com.example.loyalty.business.account.create.dto.CreateRequest;
import com.example.loyalty.controller.AccountAPIs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AccountController implements AccountAPIs {
    @Autowired
    private ICreateAccount iCreateAccount;

    @Override
    public ResponseEntity<?> createAccount(CreateRequest createRequest) {
        log.info(createRequest.toString());
        return ResponseEntity.ok(iCreateAccount.createAccount(createRequest));
    }
}
