package com.example.testApp.controllers;

import com.example.testApp.models.Article;
import com.example.testApp.models.Comment;
import com.example.testApp.service.ArticleService;
import com.example.testApp.service.CommentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/articles")
public class ArticleController {
    CommentService cm;
    ArticleService articleService ;

    public ArticleController(CommentService cm, ArticleService articleService) {
        this.cm = cm;
        this.articleService = articleService;
    }

    @PostMapping("/add")
    public Article createArticle(@RequestParam("article") String article, @RequestParam("image") MultipartFile mf) throws IOException {
        Article a = new ObjectMapper().readValue(article, Article.class);
        return articleService.saveArticle(a,mf);
    }
  @DeleteMapping("/delete/{idArticle}")
    public Article deleteArticle(@PathVariable("idArticle") Long idArticle){
        return articleService.deleteArticle(idArticle);
    }
    @GetMapping("/get/{idArticle}")
    public Article getArticle(@PathVariable("idArticle") Long idArticle){

        return articleService.getArticle(idArticle);
    }
    @GetMapping("/all/{type}")
    public ArrayList<Article> listArticles(@PathVariable("type") String type){
        return articleService.findByType(type);
    }

    @PostMapping("/update")
    public Article updateArticle(@RequestParam("article") Article article,
                                 @RequestParam(name = "image",required = false) MultipartFile m)throws IOException{
        return articleService.saveArticle(article,m);
    }
    @PostMapping("/addcomment")
    public Article addComment(@RequestParam("article") String article,
                                    @RequestParam(value = "image",required = false) MultipartFile m,
                                    @RequestParam("comment") String comment) throws IOException{
        Article a = new ObjectMapper().readValue(article, Article.class);
        Comment c = new ObjectMapper().readValue(comment, Comment.class);
        cm.createComment(c,a.getIdArticle());
        return articleService.saveArticle(a,m);
    }

    @GetMapping("/home/{type}")
    public ArrayList<Article> getTopArticles(@PathVariable("type") String type){
        return articleService.getarticles(type);
    }
    @GetMapping(path ="/getImage/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage(@PathVariable Long  id) throws IOException
    {
        //System.out.printf("id:");
        //System.out.print(id);
        return articleService.getImages(id);

    }

}
