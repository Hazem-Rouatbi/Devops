import { ThisReceiver } from '@angular/compiler';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Observable } from 'rxjs';
import { Article } from '../models/article';
import { ArticleService } from '../services/article.service';
import { Router } from '@angular/router';

import { Comment } from '../models/comment';
@Component({
  selector: 'app-article-temp',
  templateUrl: './article-temp.component.html',
  styleUrls: ['./article-temp.component.scss']
})
export class ArticleTempComponent implements OnInit,OnDestroy{

  constructor(private artiserv:ArticleService,private route:ActivatedRoute,private router:Router) { }
  article!:Article;
  comments?:Comment[];
  artID:number=1;
  mysub:any;
  myComment?:Comment;
  commenttext!:string;

  ngOnInit(): void {
    this.mysub= this.route.params.subscribe((params) => this.artID=params['id']);
    this.artiserv.getArticle(this.artID).subscribe(art=>this.article=art);
    this.artiserv.getComments(this.artID).subscribe(res => this.comments=res)
  }
  ngOnDestroy(): void {
    this.mysub.unsubscribe()
  }
  subComment():void{
    this.myComment={
      text:this.commenttext
    }
    console.log(this.commenttext);
    let fd= new FormData();
    fd.append("article",JSON.stringify(this.article))
    fd.append("comment",JSON.stringify(this.myComment))
    console.log(fd);
    this.artiserv.addComment(fd).subscribe(res=> {this.comments=res})
    this.artiserv.getComments(this.artID).subscribe(res => this.comments=res)


   }

  editArticle(){
    this.router.navigate([`/Create`,{id:this.article.idArticle}]);
  }
  deleteArticle(){
    this.artiserv.deleteArticle(this.artID).subscribe(art =>(this.router.navigate([`/Home`])));

  }

  
}
