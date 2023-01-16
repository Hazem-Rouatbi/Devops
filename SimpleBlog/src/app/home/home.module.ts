import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TopComponent } from './top/top.component';
import { ComArticlesComponent } from './com-articles/com-articles.component';
import { GuideArticlesComponent } from './guide-articles/guide-articles.component';
import { RouterModule } from '@angular/router';
import { PipesModule } from '../pipes.module';



@NgModule({
  declarations: [TopComponent, 
    ComArticlesComponent, 
    GuideArticlesComponent],
  imports: [
    RouterModule,
    CommonModule,
    PipesModule
    ],
  exports:[TopComponent, 
    ComArticlesComponent, 
    GuideArticlesComponent]
})
export class HomeModule { }
