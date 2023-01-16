import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticleTempComponent } from './article-temp.component';

describe('ArticleTempComponent', () => {
  let component: ArticleTempComponent;
  let fixture: ComponentFixture<ArticleTempComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ArticleTempComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ArticleTempComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
