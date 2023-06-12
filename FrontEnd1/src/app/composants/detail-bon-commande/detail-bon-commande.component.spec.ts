import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailBonCommandeComponent } from './detail-bon-commande.component';

describe('DetailBonCommandeComponent', () => {
  let component: DetailBonCommandeComponent;
  let fixture: ComponentFixture<DetailBonCommandeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailBonCommandeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailBonCommandeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
