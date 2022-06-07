package com.xar.lore.service;

import com.xar.lore.dto.AuthenticationResponse;
import com.xar.lore.dto.LoginRequest;
import com.xar.lore.dto.RefreshTokenRequest;
import com.xar.lore.dto.RegisterRequest;
import com.xar.lore.exceptions.SpringRedditException;
import com.xar.lore.model.NotificationEmail;
import com.xar.lore.model.User;
import com.xar.lore.model.VerificationToken;
import com.xar.lore.repository.UserRepository;
import com.xar.lore.repository.VerificationTokenRepository;
import com.xar.lore.security.JwtProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

public class AuthService {
}
