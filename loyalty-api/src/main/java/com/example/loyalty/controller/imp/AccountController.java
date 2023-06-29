package com.example.loyalty.controller.imp;

import com.example.loyalty.business.account.create.ICreateAccount;
import com.example.loyalty.business.account.create.dto.CreateRequest;
import com.example.loyalty.controller.AccountAPIs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController implements AccountAPIs {
    @Autowired
    private ICreateAccount iCreateAccount;

    @Override
    public ResponseEntity<?> createAccount(CreateRequest createRequest) {
        return ResponseEntity.ok(iCreateAccount.createAccount(createRequest));
    }
}
