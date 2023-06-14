import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NouveauBonCommandeComponent } from './nouveau-bon-commande.component';

describe('NouveauBonCommandeComponent', () => {
  let component: NouveauBonCommandeComponent;
  let fixture: ComponentFixture<NouveauBonCommandeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NouveauBonCommandeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NouveauBonCommandeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
