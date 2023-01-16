package com.example.testApp.controllers;

import com.example.testApp.models.Comment;
import com.example.testApp.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/comment")
class CommentController{

    CommentService cs;

    public CommentController(CommentService cm) {
        this.cs = cm;
    }

    @PostMapping("/{id}/update")
    public Comment updateComment (@RequestBody Comment comment,@PathVariable Long id){
        return cs.updateComment(comment);
    }
    @PostMapping("/{id}/add")
    public Comment createComment ( @RequestBody Comment comment,@PathVariable Long id){
        return cs.createComment(comment,id);
    }
    @GetMapping("/{id}/all")
    public List<Comment> listComments(@PathVariable Long id){
        return cs.listArticleComments(id);
    }


}