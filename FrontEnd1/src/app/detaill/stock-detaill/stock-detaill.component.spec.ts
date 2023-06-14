import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StockDetaillComponent } from './stock-detaill.component';

describe('StockDetaillComponent', () => {
  let component: StockDetaillComponent;
  let fixture: ComponentFixture<StockDetaillComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StockDetaillComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StockDetaillComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
