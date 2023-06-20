import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailBilanFinanceComponent } from './detail-bilan-finance.component';

describe('DetailBilanFinanceComponent', () => {
  let component: DetailBilanFinanceComponent;
  let fixture: ComponentFixture<DetailBilanFinanceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailBilanFinanceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailBilanFinanceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
