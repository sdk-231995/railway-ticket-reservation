package com.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.LoginCredential;
import com.user.entity.PassengerInfo;
import com.user.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public void registerUser(LoginCredential login, PassengerInfo passengerInfo) {
        repo.saveLogin(login);
        repo.savePax(passengerInfo);
    }

    public boolean validateLogin(String loginId, String password) {
        LoginCredential login = repo.findLogin(loginId);
        return login != null && login.getPassword().equals(password);
    }
}
