package com.xar.lore.service;

import com.xar.lore.dto.CommentsDto;
import com.xar.lore.exceptions.PostNotFoundException;
import com.xar.lore.exceptions.LoreException;
import com.xar.lore.mapper.CommentMapper;
import com.xar.lore.model.Comment;
import com.xar.lore.model.NotificationEmail;
import com.xar.lore.model.Post;
import com.xar.lore.model.User;
import com.xar.lore.repository.CommentRepository;
import com.xar.lore.repository.PostRepository;
import com.xar.lore.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class CommentService {
}
