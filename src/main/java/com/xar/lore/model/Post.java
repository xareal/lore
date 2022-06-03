package com.xar.lore.model;


@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {
	@Id
	@GeneratedValue(startegy = IDENTITY)
	private Long postId;
	@NotBlank(message = "Post Name cannot be empty or Null")
	private String postName;
	@Nullable
	private String url;
	@Nullable
	@Lob
	private String description;
	private Integer voteCount;
	@ManyToOne(fetch = LAZY)
	@JoinCollumn(name = "userId", referencedColumnName = "userId")
	private User user;
	private Instant createDate;
	@ManyToOne(fetch = LAZY)
	@JoinCollumn(name = "id", referencedColumnName = "id")
	private Subreddit subreddit;

}

