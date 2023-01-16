package com.example.testApp.service;

import com.example.testApp.models.Comment;

import java.util.ArrayList;
import java.util.List;


public interface CommentService {
    public Comment getComment(Long commentId);
    public Comment createComment(Comment comment,Long id);
    public Comment updateComment(Comment comment);
    public Comment deleteComment(Long commentId);
    public List<Comment> listArticleComments(Long id);
}
