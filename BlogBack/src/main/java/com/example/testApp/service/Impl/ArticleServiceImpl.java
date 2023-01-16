package com.example.testApp.service.Impl;

import com.example.testApp.models.Article;
import com.example.testApp.models.Comment;
import com.example.testApp.repository.ArticleRepo;
import com.example.testApp.service.ArticleService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {


    ArticleRepo articleRepo;

    public ArticleServiceImpl(ArticleRepo articleRepo) {
        this.articleRepo = articleRepo;
    }

    @Override
    public Article saveArticle(Article article , MultipartFile mf) throws IOException {
        String image;
        if(mf!=null){
            image= saveImage(mf);
            article.setImage(image);
        }

        return  articleRepo.save(article);
    }


    @Override
    public Article deleteArticle(Long articleId) {
        Article article=articleRepo.findById(articleId).get();
        articleRepo.deleteById(articleId);
        return article;
    }

    @Override
    public Article getArticle(Long articleId) {
        return articleRepo.findById(articleId).get();
    }

    @Override
    public ArrayList<Article> getarticles(String type) {
        return articleRepo.gettopfour(type);
    }

    @Override
    public ArrayList<Article> listArticles() {
        List<Article> articles =articleRepo.findAll();
        ArrayList<Article> arrarticles=new ArrayList<Article>(articles);
        return arrarticles;
    }

    @Override
    public ArrayList<Article> findByType(String type) {
        return articleRepo.findArticlesByType(type);
    }
    @Override
    public String saveImage(MultipartFile mf) throws IOException {
        String nameFile = mf.getOriginalFilename();
        String tab[] =nameFile.split("\\.");
        String fileModif = tab[0]+"_"+System.currentTimeMillis()+"."+tab[1];

        String chemin = System.getProperty("user.home")+"/imagesSpring";
        Path p = Paths.get(chemin,fileModif);
        File f= new File(chemin);

        Files.write(p,mf.getBytes());
        return fileModif;
    }

    @Override
    public byte[] getImages(Long id) throws IOException {
        String chemin = System.getProperty("user.home")+"/imagesSpring";
        Path path = Paths.get(chemin,getArticle(id).getImage());
        return Files.readAllBytes(path);
    }
}
