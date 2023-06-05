import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticleDetaillComponent } from './article-detaill.component';

describe('ArticleDetaillComponent', () => {
  let component: ArticleDetaillComponent;
  let fixture: ComponentFixture<ArticleDetaillComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ArticleDetaillComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArticleDetaillComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
