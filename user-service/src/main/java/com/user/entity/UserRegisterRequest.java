package com.user.entity;

import lombok.Data;

@Data
public class UserRegisterRequest {
    private LoginCredential login;
    private PassengerInfo passengerInfo;
}
