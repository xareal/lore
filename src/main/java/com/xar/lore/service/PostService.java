package com.xar.lore.service;

import com.xar.lore.dto.PostRequest;
import com.xar.lore.dto.PostResponse;
import com.xar.lore.exceptions.PostNotFoundException;
import com.xar.lore.exceptions.SubredditNotFoundException;
import com.xar.lore.mapper.PostMapper;
import com.xar.lore.model.Post;
import com.xar.lore.model.Subreddit;
import com.xar.lore.model.User;
import com.xar.lore.repository.PostRepository;
import com.xar.lore.repository.SubredditRepository;
import com.xar.lore.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class PostService {
}
