package com.example.testApp.service;

import com.example.testApp.models.Article;
import com.example.testApp.models.Comment;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface ArticleService {
    public Article saveArticle(Article article ,MultipartFile multipartFile) throws IOException;
    public Article deleteArticle(Long articleId);
    public Article getArticle(Long articleId);
    public ArrayList<Article> listArticles();
    public ArrayList<Article> findByType(String type);
    public ArrayList<Article> getarticles(String type);

    public String saveImage(MultipartFile multipartFile) throws IOException;
    public byte[] getImages(Long id) throws IOException;
}
