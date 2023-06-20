import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BilanFinanceDetaillComponent } from './bilan-finance-detaill.component';

describe('BilanFinanceDetaillComponent', () => {
  let component: BilanFinanceDetaillComponent;
  let fixture: ComponentFixture<BilanFinanceDetaillComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BilanFinanceDetaillComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BilanFinanceDetaillComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
