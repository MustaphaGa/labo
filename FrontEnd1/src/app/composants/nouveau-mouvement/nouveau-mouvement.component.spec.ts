import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NouveauMouvementComponent } from './nouveau-mouvement.component';

describe('NouveauMouvementComponent', () => {
  let component: NouveauMouvementComponent;
  let fixture: ComponentFixture<NouveauMouvementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NouveauMouvementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NouveauMouvementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
