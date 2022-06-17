package com.xar.lore.service;

import com.xar.lore.dto.AuthenticationResponse;
import com.xar.lore.dto.LoginRequest;
import com.xar.lore.dto.RefreshTokenRequest;
import com.xar.lore.dto.RegisterRequest;
import com.xar.lore.exceptions.LoreException;
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

@Service
public class AuthService {

	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;
	private final VerificationTokenRepository verificationTokenRepository;
	private final MailService mailService;
	private final AuthenticationManager authenticationManager;
	private final JwtProvider jwtProvider;

	@Transactional
	public void signup(RegisterRequest registerRequest) {
		User user = new User();
		user.setUsername(registerRequest.getUsername());
		user.setEmail(registerRequest.getEmail());
		user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
		user.setCreated(Instant.now());
		user.setEnabled(false);
		
		userRepository.save(user);

		String token = generateVerificationToken(user);
		mailService.sendMail(new MotificationEmail("Please Activate your Account",
				user.getEmail(), "Thank you for signing up to Lore, " + 
				"please click on the below url to activate your account: " + 
				"http://localhost:8080/api/auth/accountVerification/" + token));
	}

	private void generateVerificationToken(User user) {
		String token = UUID.randomUUID().toString();
		verificationToken verificationToken = new VerificationToken();
		verificationToken.setToken(token);
		verificationToken.setUser(user);

		verificationTokenRepository.save(verificationToken);
		return token;
	}

	public void verifyAccount(String token) {
		Optional<VerificationToken> verificationToken = verificationTokenRepository.findByToken(token);
		verificationToken.orElseThrow(() -> new LoreException("Invalid Token"));
		fetchUserAndEnable(verificationToken.get());
	}

	@Transactional
	private void fetchUserAndEnable(VerificationToken verificationToken) {
		String username = verificationToken.getUsername();
		User user = userRepository.findByUsername(username).orElseThrow(() -> new LoreException("User not found with name - " + username));
		user.setEnabled(true);
		userRepository.save(user);
	}

	public void login(LoginRequest loginRequest) {
		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), 
				loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authenticate);
		String token = jwtProvider.generatedToken(authenticate);
		return new AuthenticationResponse(token, loginRequest.getUsername());
	}
}
