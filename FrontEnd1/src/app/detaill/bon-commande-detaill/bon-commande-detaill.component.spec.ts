import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BonCommandeDetaillComponent } from './bon-commande-detaill.component';

describe('BonCommandeDetaillComponent', () => {
  let component: BonCommandeDetaillComponent;
  let fixture: ComponentFixture<BonCommandeDetaillComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BonCommandeDetaillComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BonCommandeDetaillComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
