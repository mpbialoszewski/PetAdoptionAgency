package com.mpb.petadoptionagency.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/check-role")
    public String check(Authentication auth) {
        return "Your authorities: " + auth.getAuthorities();
    }
}
