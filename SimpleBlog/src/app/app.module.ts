import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import {MatIconModule} from '@angular/material/icon'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { HomeModule } from './home/home.module';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginComponent } from './login/login.component';
import { CreateArticleComponent } from './create-article/create-article.component';
import { ArticleListComponent } from './article-list/article-list.component';
import { FormsModule } from '@angular/forms';
import { ArticleTempComponent } from './article-temp/article-temp.component';
import { HttpClientModule } from '@angular/common/http';
import { PipesModule } from './pipes.module';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    LoginComponent,
    CreateArticleComponent,
    ArticleListComponent,
    ArticleTempComponent,
  ],
  imports: [
    FormsModule,
    MatIconModule,
    HomeModule,
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    HttpClientModule,
    PipesModule
    
   
    
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule { }
