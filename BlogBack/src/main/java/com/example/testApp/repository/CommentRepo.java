package com.example.testApp.repository;

import com.example.testApp.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface CommentRepo extends JpaRepository<Comment,Long> {
    @Query(value = "Select * From comments where comments.article_id_article = ?1",nativeQuery = true)
    List<Comment> findCommentsbyArticleId(Long id);
}
