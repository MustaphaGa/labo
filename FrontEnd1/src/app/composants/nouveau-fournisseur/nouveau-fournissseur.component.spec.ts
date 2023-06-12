import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NouveauFournisseurComponent } from './nouveau-fournissseur.component';

describe('NouveauFournissseurComponent', () => {
  let component: NouveauFournisseurComponent;
  let fixture: ComponentFixture<NouveauFournisseurComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NouveauFournisseurComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NouveauFournisseurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
