import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PageBonCommandeComponent } from './page-bon-commande.component';

describe('PageBonCommandeComponent', () => {
  let component: PageBonCommandeComponent;
  let fixture: ComponentFixture<PageBonCommandeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PageBonCommandeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PageBonCommandeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
