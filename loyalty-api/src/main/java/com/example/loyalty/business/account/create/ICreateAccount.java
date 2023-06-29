package com.example.loyalty.business.account.create;


import com.example.loyalty.business.account.create.dto.CreateResponse;
import com.example.loyalty.business.account.create.dto.CreateRequest;

public interface ICreateAccount {
    CreateResponse createAccount(CreateRequest request);
}
