package com.xar.lore.repository;

import com.xar.lore.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository JpaRepository<Comment, Long> {
}
