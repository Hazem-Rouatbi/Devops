import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Article } from 'src/app/models/article';
import { ArticleService } from 'src/app/services/article.service';
@Component({
  selector: 'app-guide-articles',
  templateUrl: './guide-articles.component.html',
  styleUrls: ['./guide-articles.component.scss']
})
export class GuideArticlesComponent implements OnInit {

  constructor(private artiserv:ArticleService) { }
  articles?:Article[];

  ngOnInit(): void {
    this.artiserv.homeGuiArticles().subscribe(art=>this.articles=art);
  }
  handleError(event :Event){
    (event.target as HTMLImageElement).src='/assets/placeholder.jpg'
  }

}
