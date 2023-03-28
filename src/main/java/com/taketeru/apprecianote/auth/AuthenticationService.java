package com.taketeru.apprecianote.auth;

import com.taketeru.apprecianote.security.JwtService;
import com.taketeru.apprecianote.token.Token;
import com.taketeru.apprecianote.token.TokenRepository;
import com.taketeru.apprecianote.token.TokenType;
import com.taketeru.apprecianote.user.Role;
import com.taketeru.apprecianote.user.User;
import com.taketeru.apprecianote.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        User user = User.builder()
//                .firstname(request.getFirstname())
//                .lastname(request.getLastname())
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        User savedUser = repository.save(user);
        String jwtToken = jwtService.generateToken(user);
        saveUserToken(savedUser, jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        System.out.println("authenticate service!!!");
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        System.out.println("authenticate 11111111111111111!!!");
        User user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        System.out.println("authenticate 22222222222222222!!!");
        String jwtToken = jwtService.generateToken(user);
        System.out.println("authenticate 33333333333333333!!!");
        revokeAllUserTokens(user);
        System.out.println("authenticate 44444444444444444!!!");
        saveUserToken(user, jwtToken);
        System.out.println("authenticate 55555555555555555!!!");
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    private void saveUserToken(User user, String jwtToken) {
        Token token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user) {
        List<Token> validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }
}