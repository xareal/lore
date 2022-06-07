package com.xar.lore.mapper;

import com.github.marlonlom.utilities.timeago.TimeAgo;
import com.xar.lore.dto.PostRequest;
import com.xar.lore.dto.PostResponse;
import com.xar.lore.model.*;
import com.xar.lore.repository.CommentRepository;
import com.xar.lore.repository.VoteRepository;
import com.xar.lore.service.AuthService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static com.xar.lore.model.VoteType.DOWNVOTE;
import static com.xar.lore.model.VoteType.UPVOTE;

public interface PostMapper {
}
