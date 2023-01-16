package com.example.testApp.repository;

import com.example.testApp.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;


public interface ArticleRepo  extends JpaRepository<Article,Long> {

    @Query(value = "Select * From articles where articles.type = ?1",nativeQuery = true)
    ArrayList<Article> findArticlesByType(String type);
    @Query(value = "select * from articles where articles.type=?1 order by articles.id_article desc limit 3",nativeQuery = true)
    ArrayList<Article> gettopfour(String type);
}
