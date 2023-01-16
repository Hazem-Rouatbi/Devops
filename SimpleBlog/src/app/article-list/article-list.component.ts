import { Component, Input, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Article } from '../models/article';
import { ArticleService } from '../services/article.service';

@Component({
  selector: 'app-article-list',
  templateUrl: './article-list.component.html',
  styleUrls: ['./article-list.component.scss']
})
export class ArticleListComponent implements OnInit {

  guiArticles:Article[]=[];
  comArticles:Article[]=[];
  
  searchTerm='';
  
  constructor(private artiserv:ArticleService) { }
  comActive=false;
  articActive=true;

  changeselection(){
    this.comActive=!this.comActive;
    this.articActive=!this.articActive;
  }

  ngOnInit(): void {
  this.artiserv.geComArticles().subscribe(articles => this.comArticles = articles);
  this.artiserv.geGuiArticles().subscribe(articles => this.guiArticles = articles);
  }


}
