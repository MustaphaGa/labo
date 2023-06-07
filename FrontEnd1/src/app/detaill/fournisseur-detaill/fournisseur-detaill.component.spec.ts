import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FournisseurDetaillComponent } from './fournisseur-detaill.component';

describe('FournisseurDetaillComponent', () => {
  let component: FournisseurDetaillComponent;
  let fixture: ComponentFixture<FournisseurDetaillComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FournisseurDetaillComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FournisseurDetaillComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
