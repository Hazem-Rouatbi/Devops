import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ArticleListComponent } from './article-list/article-list.component';
import { ArticleTempComponent } from './article-temp/article-temp.component';
import { CreateArticleComponent } from './create-article/create-article.component';
import { LoginGuard } from './guard/login.guard';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [{path:'Home',component:HomeComponent,},
                        {path:'',component:LoginComponent},
                        {path:'Create',component:CreateArticleComponent},
                        {path:'Articles',component:ArticleListComponent},
                        {path:`Articles/:id`,component:ArticleTempComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers:[LoginGuard]
})
export class AppRoutingModule { }
