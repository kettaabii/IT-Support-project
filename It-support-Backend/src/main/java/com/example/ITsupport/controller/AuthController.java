package com.example.ITsupport.controller;

import com.example.ITsupport.Dto.LoginRequest;
import com.example.ITsupport.Dto.LoginResponse;
import com.example.ITsupport.Dto.SignupRequest;
import com.example.ITsupport.entity.Person;
import com.example.ITsupport.security.JwtHelper;
import com.example.ITsupport.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    private final PersonService personService;

    public AuthController(PersonService personService) {
        this.personService = personService;
    }


    @PostMapping("public/signup")
    public ResponseEntity<Void> register(@RequestBody SignupRequest signupRequest) {
        personService.signUp(signupRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("public/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));
        Person user = personService.findUserByUsername(loginRequest.username());
        String token = JwtHelper.generateToken(loginRequest.username(),user.getRole());

        LoginResponse response = new LoginResponse(token, user);

        return ResponseEntity.ok(response);
    }

//    @PostMapping("/logout")
//    public ResponseEntity<Void> logout() {
//
//
//    }
}
