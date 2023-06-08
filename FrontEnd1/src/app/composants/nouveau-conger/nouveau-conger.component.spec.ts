import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NouveauCongerComponent } from './nouveau-conger.component';

describe('NouveauCongerComponent', () => {
  let component: NouveauCongerComponent;
  let fixture: ComponentFixture<NouveauCongerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NouveauCongerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NouveauCongerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
