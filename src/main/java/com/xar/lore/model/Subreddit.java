package com.xar.lore.model;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Subreddit {
	@Id
	@GeneratedValue(startegy = IDENTITY)
	private Long id;
	@NotBlank(message = "Community name is required")
	private String name;
	@NotBlank(message = "Description is required")
	private String description;
	@OneToMany(fetch = LAZY)
	private List<Post> posts;
	private Instant createDate;
	@ManyToOne(fetch =LAZY)
	private User user;
}
