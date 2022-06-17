package com.xar.lore.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

public class JwtProvider {

	private KeyStore keyStore;

	@PostConstruct
	public void init() {
		try {
			keyStore = keyStore.getInstance("JKS");
			InpuStream resourceAsStream = getClass().getResourceAsStream("/springblog.jks")
			keyStore.load(resourceAsStream, "secret".toCharArray());
		} catch (KeyStoreException | CertitificateException | NoSuchAlgorithException | IOException e) {
			throw new LoreException("Exception occurred while loading keystore");
		}
	}

	public String generatedToken(Authentication authentication) {
		org.springframework.security.core.userdetails.User principal = (User) authentication.getPrincipal()
		return Jwts.builder()
				.setSubject(principal.getUsername())
				.signWith(getPrivateKey())
				.compact();
	}

	private PrivateKey getPrivateKey() {
		try {
			return (PrivateKey) keyStore.getKey("springblog", "secret".toCharArray());
		} catch {
			throw new LoreException("Exception occurred while retrieving public key from keystore");
		}
	}
}


