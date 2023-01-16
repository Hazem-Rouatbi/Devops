import { Component, Input, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Article } from '../models/article';
import { ArticleService } from '../services/article.service';
import { Comment } from '../models/comment';



@Component({
  selector: 'app-create-article',
  templateUrl: './create-article.component.html',
  styleUrls: ['./create-article.component.scss']
})
export class CreateArticleComponent implements OnInit {
  id?: number;
  image!: File;
  imagename?: string;
  title: string = "";
  text: string = "";
  comments?: Comment[];
  type: string = "";
  article!: Article;
  mysub: any;
  comActive = false;
  articActive = true;

  constructor(private artserv: ArticleService, private router: Router, private route: ActivatedRoute) {
    if (this.route.snapshot.paramMap.get('id')) {
      this.id = Number(this.route.snapshot.paramMap.get('id'));
      this.artserv.getArticle(this.id).subscribe(art => {
        this.imagename = art.image;
        this.type = art.type;
        this.title = art.title;
        this.text = art.text;
      }
      );
    }
  }
  submit() {
    this.setType()
    if (this.id) {
      this.article = {
        idArticle: this.id,
        title: this.title,
        text: this.text,
        type: this.type
      }
    }
    else {

      this.article = {
        type: this.type,
        title: this.title,
        text: this.text,
      }
    }
    if (this.article.idArticle) {

    }
    let fd = new FormData();
    fd.append('image', this.image);
    fd.append('article', JSON.stringify(this.article));
    console.log(this.article)
    this.add(fd)
  }
  onFileChange(event: any) {
    this.image = event.files[0];  }

  changeselection() {
    this.comActive = !this.comActive;
    this.articActive = !this.articActive;  }

  setType() {
    this.type = this.comActive ? "COM" : "GUI";}

  add(fd: FormData) {
    if (!this.article.title || !this.article.text || !this.article.type) {
      alert("be sure to fill all the spaces please");
      return;
    }
    this.artserv.addArticle(fd).subscribe(art => (this.router.navigate([`/Articles`, art.idArticle])));}

  ngOnInit(): void {
    console.log(this.type)
    if (this.type == "GUI")
      this.changeselection();
  }

}
