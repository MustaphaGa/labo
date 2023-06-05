import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NouveauArticleComponent } from './nouveau-article.component';

describe('NouveauArticleComponent', () => {
  let component: NouveauArticleComponent;
  let fixture: ComponentFixture<NouveauArticleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NouveauArticleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NouveauArticleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
