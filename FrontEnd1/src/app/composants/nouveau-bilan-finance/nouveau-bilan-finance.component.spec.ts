import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NouveauBilanFinanceComponent } from './nouveau-bilan-finance.component';

describe('NouveauBilanFinanceComponent', () => {
  let component: NouveauBilanFinanceComponent;
  let fixture: ComponentFixture<NouveauBilanFinanceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NouveauBilanFinanceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NouveauBilanFinanceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
