import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NouveauFournissseurComponent } from './nouveau-fournissseur.component';

describe('NouveauFournissseurComponent', () => {
  let component: NouveauFournissseurComponent;
  let fixture: ComponentFixture<NouveauFournissseurComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NouveauFournissseurComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NouveauFournissseurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
