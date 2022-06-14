package com.xar.lore.controller;

import com.xar.lore.dto.AuthenticationResponse;
import com.xar.lore.dto.LoginRequest;
import com.xar.lore.dto.RefreshTokenRequest;
import com.xar.lore.dto.RegisterRequest;
import com.xar.lore.service.AuthService;
import com.xar.lore.service.RefreshTokenService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private final AuthService authService;

	@PostMapping("/signup")
	public void signup(@RequestBody RegisterRequest registerRequest) {
		authService.signup(registerRequest);
		return new ResponseEntity<>("User Registration Successful", 
				HttpStatus.OK);
		 
	}

	@GetMapping("accountVerification/{token}")
	public ResponseEntity<String> verifyAccount(@PathVariable String token) {
		authService.verifyAccount(token);
	}
}


