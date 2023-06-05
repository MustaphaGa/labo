import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PageArticleComponent } from './page-article.component';

describe('PageArticleComponent', () => {
  let component: PageArticleComponent;
  let fixture: ComponentFixture<PageArticleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PageArticleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PageArticleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
