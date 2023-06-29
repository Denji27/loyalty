package com.example.loyalty.business.account.create.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateResponse {
    String name;
    String address;
    String phoneNumber;
    String email;
}
