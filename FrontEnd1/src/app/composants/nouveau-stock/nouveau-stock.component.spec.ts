import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NouveauStockComponent } from './nouveau-stock.component';

describe('NouveauStockComponent', () => {
  let component: NouveauStockComponent;
  let fixture: ComponentFixture<NouveauStockComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NouveauStockComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NouveauStockComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
