package com.pfe.testapp.controller;

import com.pfe.testapp.dto.AdminRegisterRequest;
import com.pfe.testapp.dto.CandidateRegisterRequest;
import com.pfe.testapp.dto.RecruiterRegisterRequest;
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

    @PostMapping("/register/recruiter")
    public ResponseEntity<RegisterResponse> registerRecruiter(
            @RequestBody RecruiterRegisterRequest request) {

        RegisterResponse response = authService.registerRecruiter(request);
        if (response.isSuccess()) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().body(response);
    }

    @PostMapping("/register/admin")
    public ResponseEntity<RegisterResponse> registerAdmin(
            @RequestBody AdminRegisterRequest request) {

        RegisterResponse response = authService.registerAdmin(request);
        if (response.isSuccess()) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().body(response);
    }

}
