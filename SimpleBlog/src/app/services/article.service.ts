import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Article } from '../models/article';
import { Comment } from '../models/comment';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {
  constructor(private http: HttpClient) { }
  serverUrl = environment.baseUrl;
  articleUrl = `${this.serverUrl}/articles`
  commentUrl = `${this.serverUrl}/comment`


  addArticle(fd:FormData): Observable<Article> {

    return this.http.post<Article>(`${this.articleUrl}/add`, fd)
  }
  geComArticles(): Observable<Article[]> {
    return this.http.get<Article[]>(`${this.articleUrl}/all/COM`)
  }
  geGuiArticles(): Observable<Article[]> {
    return this.http.get<Article[]>(`${this.articleUrl}/all/GUI`)
  }
  getArticle(id: number): Observable<Article> {
    return this.http.get<Article>(`${this.articleUrl}/get/${id}`)
  }
  homeComArticles(): Observable<Article[]> {
    return this.http.get<Article[]>(`${this.articleUrl}/home/COM`)
  }
  homeGuiArticles(): Observable<Article[]> {
    return this.http.get<Article[]>(`${this.articleUrl}/home/GUI`)
  }
  addComment(fd:FormData): Observable<Comment[]> {
    return this.http.post<Comment[]>(`${this.articleUrl}/addcomment`, fd)
  }
  getComments(id:number): Observable<Comment[]> {
    return this.http.get<Comment[]>(`${this.commentUrl}/${id}/all`)
  }
  deleteArticle(id:number):Observable<Article>{
    return this.http.delete<Article>(`${this.articleUrl}/delete/${id}`)
  }
  getImage(id:number):Observable<File>{
  return this.http.get<File>(`$http://localhost:8080/articles/getImage/${id}`)
  }
}