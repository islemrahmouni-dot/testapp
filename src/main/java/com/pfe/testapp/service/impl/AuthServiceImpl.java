package com.pfe.testapp.service.impl;

import com.pfe.testapp.entities.Recruiter;
import com.pfe.testapp.entities.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pfe.testapp.dto.AdminRegisterRequest;
import com.pfe.testapp.dto.CandidateRegisterRequest;
import com.pfe.testapp.dto.LoginRequest;
import com.pfe.testapp.dto.LoginResponse;
import com.pfe.testapp.dto.RecruiterRegisterRequest;
import com.pfe.testapp.dto.RegisterResponse;
import com.pfe.testapp.entities.Candidate;
import com.pfe.testapp.entities.Role;
import com.pfe.testapp.repositories.CandidateRepository;
import com.pfe.testapp.repositories.RecruiterRepository;
import com.pfe.testapp.repositories.UserRepository;
import com.pfe.testapp.service.AuthService;


@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final CandidateRepository candidateRepository;
    private final RecruiterRepository recruiterRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, CandidateRepository candidateRepository,
                           RecruiterRepository recruiterRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.candidateRepository = candidateRepository;
        this.recruiterRepository = recruiterRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public RegisterResponse registerCandidate(CandidateRegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            return RegisterResponse.builder().success(false).message("email existe déja").build();
        }

        Candidate candidate = new Candidate();
        candidate.setEmail(request.getEmail());
        candidate.setNom(request.getNom());
        candidate.setPassword(passwordEncoder.encode(request.getPassword()));
        candidate.setRole(Role.CANDIDATE);
        candidate.setStatutCompte(true);
        candidate.setNumTelephone(request.getNumTelephone());

        Candidate savedcandidate = candidateRepository.save(candidate);

        return RegisterResponse.builder()
                .id(savedcandidate.getId())
                .email(savedcandidate.getEmail())
                .nom(savedcandidate.getNom())
                .role(savedcandidate.getRole())
                .success(true)
                .message("Candidat enregistré avec succès")
                .build();
    }

    @Override
    public RegisterResponse registerRecruiter(RecruiterRegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            return RegisterResponse.builder()
                    .success(false)
                    .message("email existe déjà")
                    .build();
        }

        Recruiter recruiter = new Recruiter();
        recruiter.setEmail(request.getEmail());
        recruiter.setNom(request.getNom());
        recruiter.setPassword(passwordEncoder.encode(request.getPassword()));
        recruiter.setRole(Role.RECRUITER);
        recruiter.setStatutCompte(true);

        recruiter.setFonction(request.getFonction());
        recruiter.setPoste(request.getPoste());
        recruiter.setDepartement(request.getDepartement());

        Recruiter savedRecruiter = recruiterRepository.save(recruiter);

        return RegisterResponse.builder()
                .id(savedRecruiter.getId())
                .email(savedRecruiter.getEmail())
                .nom(savedRecruiter.getNom())
                .role(savedRecruiter.getRole())
                .success(true)
                .message("Recruiter enregistré avec succès")
                .build();
    }

    @Override
    public RegisterResponse registerAdmin(AdminRegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            return RegisterResponse.builder()
                    .success(false)
                    .message("email existe déjà")
                    .build();
        }

        User admin = new User();
        admin.setEmail(request.getEmail());
        admin.setNom(request.getNom());
        admin.setPassword(passwordEncoder.encode(request.getPassword()));
        admin.setRole(Role.ADMIN);
        admin.setStatutCompte(true);

        User savedAdmin = userRepository.save(admin);

        return RegisterResponse.builder()
                .id(savedAdmin.getId())
                .email(savedAdmin.getEmail())
                .nom(savedAdmin.getNom())
                .role(savedAdmin.getRole())
                .success(true)
                .message("Admin enregistré avec succès")
                .build();
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        return null;
    }




}
