package com.savvy.dec.controller;

import com.savvy.dec.entity.RegistrationRequest;
import com.savvy.dec.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/registration")
    public String register(@RequestBody RegistrationRequest registrationRequest) throws ExecutionException, InterruptedException {
        return registrationService.register(registrationRequest);

    }

    @GetMapping(path = "/registration/confirm")
    public String confirm(@RequestParam("token") String token) throws ExecutionException, InterruptedException {
        return registrationService.confirmToken(token);
    }
}
