package com.example.loyalty.business.account.create.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRequest {
    private String name;
    private String phoneNumber;
    private String address;
    private String email;
    private String gender;

}
