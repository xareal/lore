package com.xar.lore.model;

@Data
@NoArgsConstructor
@Entity
@Builder
public class Vote {
	@Id
	@GeneratedValue(startegy = IDENTITY)
	private Long voteId;
	private VoteType voteType;
	@NotNull
	@ManyToOne(fetch = LAZY)
	@JoinCollumn(name = "postId", referencedColumnName = "postId")
	private Post post;
	@ManyToOne(fetch = LAZY)
	@JoinCollumn(name = "userId", referencedColumnName = "userId")
	private User user;
}
