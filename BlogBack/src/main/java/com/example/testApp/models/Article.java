package com.example.testApp.models;

import lombok.Data;


import javax.persistence.*;
import java.util.List;



@Entity
@Table(name="articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArticle;

    private String type;
    private String title;
    @Column(length = 90000)
    private String text;
    @Column (length = 64)
    private String Image;

    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "idComment")
    private List<Comment> comments;

    public Long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Long idArticle) {
        this.idArticle = idArticle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Article(Long idArticle, String type, String title, String text, String image, List<Comment> comments) {
        this.idArticle = idArticle;
        this.type = type;
        this.title = title;
        this.text = text;
        Image = image;
        this.comments = comments;
    }

    public Article() {
    }
}
