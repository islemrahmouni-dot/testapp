package com.pfe.testapp.controller;

import com.pfe.testapp.dto.CandidateRegisterRequest;
import com.pfe.testapp.dto.RegisterResponse;
import com.pfe.testapp.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins ="*")
public class AuthController {
    private final AuthService authService;
    @PostMapping("/register/candidate")
    public ResponseEntity<RegisterResponse> registerCandidate(@RequestBody CandidateRegisterRequest request) {
        RegisterResponse response = authService.registerCandidate(request);
        if (response.isSuccess()) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().body(response);
    }
}
