package com.xar.lore.model;

@Data
@NoArgsConstructor
@Entity
@Table(name = "token")
public class VerificationToken {

	@Id
	@GeneratedValue(startegy = IDENTITY)
	private Long id;
	private String token;
	@OneToOne(fetch = LAZY)
	private User user;
	private Instant expiryDate;
}
