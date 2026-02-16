package com.pfe.testapp.service;

import com.pfe.testapp.dto.*;

public interface AuthService {

    RegisterResponse registerCandidate(CandidateRegisterRequest request);
    RegisterResponse registerRecruiter(RecruiterRegisterRequest request);
    RegisterResponse registerAdmin(AdminRegisterRequest request);
    LoginResponse login (LoginRequest request);

}
