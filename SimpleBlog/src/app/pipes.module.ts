import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CutPipe } from './pipes/cut.pipe';
import { SearchPipe } from './pipes/search.pipe';
import { AppModule } from './app.module';
import { HomeModule } from './home/home.module';



@NgModule({
  declarations: [
    CutPipe,
    SearchPipe,],
  imports: [
    CommonModule,
  ],
  exports:[CutPipe,
    SearchPipe,]
})
export class PipesModule { }
