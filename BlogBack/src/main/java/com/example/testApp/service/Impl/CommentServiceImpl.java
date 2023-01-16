package com.example.testApp.service.Impl;


import com.example.testApp.models.Article;
import com.example.testApp.models.Comment;
import com.example.testApp.repository.CommentRepo;
import com.example.testApp.service.ArticleService;
import com.example.testApp.service.CommentService;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    CommentRepo commentRepo;
    ArticleService articleService;
    public CommentServiceImpl(CommentRepo commentRepo, ArticleService articleService) {
        this.commentRepo = commentRepo;
        this.articleService = articleService;
    }

    @Override
    public Comment getComment(Long commentId) {
        return commentRepo.findById(commentId).get();
    }

    @Override
    public Comment createComment(Comment comment,Long articleId) {
        Article article = articleService.getArticle(articleId);
        comment.setArticle(article);
        return commentRepo.save(comment);
    }

    @Override
    public Comment updateComment(Comment comment) {
        return commentRepo.save(comment);
    }

    @Override
    public Comment deleteComment(Long commentId) {
        Comment comment=commentRepo.findById(commentId).get();
        commentRepo.deleteById(commentId);
        return comment;
    }

    @Override
    public List<Comment> listArticleComments(Long id) {
        List<Comment> comments;
        comments = commentRepo.findCommentsbyArticleId(id);
    return comments;
    }
}
