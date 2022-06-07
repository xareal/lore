package com.xar.lore.service;

import com.xar.lore.dto.VoteDto;
import com.xar.lore.exceptions.PostNotFoundException;
import com.xar.lore.exceptions.SpringRedditException;
import com.xar.lore.model.Post;
import com.xar.lore.model.Vote;
import com.xar.lore.repository.PostRepository;
import com.xar.lore.repository.VoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.xar.lore.model.VoteType.UPVOTE;

public class VoteService {
}
