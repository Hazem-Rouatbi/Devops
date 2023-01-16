import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComArticlesComponent } from './com-articles.component';

describe('ComArticlesComponent', () => {
  let component: ComArticlesComponent;
  let fixture: ComponentFixture<ComArticlesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComArticlesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ComArticlesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
