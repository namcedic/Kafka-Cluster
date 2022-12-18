package com.savvy.dec.service;

import com.savvy.dec.entity.RegistrationRequest;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public interface RegistrationService {
    String register(RegistrationRequest registrationRequest) throws ExecutionException, InterruptedException;

    String confirmToken(String token) throws ExecutionException, InterruptedException;
}
