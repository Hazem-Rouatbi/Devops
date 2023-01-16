package com.example.testApp.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    private String username;
    private String password;
    private String photo;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private Address address;

    @ManyToMany
    @JoinTable(name = "user_spec",
            joinColumns = {@JoinColumn(name = "id_user",referencedColumnName = "idUser")},
            inverseJoinColumns = {@JoinColumn(name = "id_spec",referencedColumnName = "idSpec")})
    private List<Specilization> spec;
    @OneToMany(mappedBy = "idArticle",cascade = CascadeType.ALL)
    private List<Article> articles;


    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }



    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


    public Address getAdress() {
        return address;
    }

    public void setAdress(Address address) {
        this.address = address;
    }


    public List<Specilization> getSpec() {
        return spec;
    }

    public void setSpec(List<Specilization> spec) {
        this.spec = spec;
    }

    public User(Long idUser, String username, String password, String photo, Address address, List<Specilization> spec, List<Article> articles) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.photo = photo;
        this.address = address;
        this.spec = spec;
        this.articles = articles;
    }

    public User() {
    }
}
