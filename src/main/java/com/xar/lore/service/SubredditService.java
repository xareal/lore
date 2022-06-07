package com.xar.lore.service;

import com.xar.lore.dto.SubredditDto;
import com.xar.lore.exceptions.SpringRedditException;
import com.xar.lore.mapper.SubredditMapper;
import com.xar.lore.model.Subreddit;
import com.xar.lore.repository.SubredditRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class SubredditService {
}
