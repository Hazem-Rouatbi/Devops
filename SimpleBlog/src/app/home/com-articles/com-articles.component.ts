import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Article } from 'src/app/models/article';
import { ArticleService } from 'src/app/services/article.service';
@Component({
  selector: 'app-com-articles',
  templateUrl: './com-articles.component.html',
  styleUrls: ['./com-articles.component.scss']
})
export class ComArticlesComponent implements OnInit {
  constructor(private artiserv:ArticleService) { }
  articles?:Article[];
  
  ngOnInit(): void {
  this.artiserv.homeComArticles().subscribe(art=>this.articles=art);
  }

}
