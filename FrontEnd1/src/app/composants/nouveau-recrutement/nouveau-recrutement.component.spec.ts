import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NouveauRecrutementComponent } from './nouveau-recrutement.component';

describe('NouveauRecrutementComponent', () => {
  let component: NouveauRecrutementComponent;
  let fixture: ComponentFixture<NouveauRecrutementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NouveauRecrutementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NouveauRecrutementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
