import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PageServiceFinanceComponent } from './page-service-finance.component';

describe('PageServiceFinanceComponent', () => {
  let component: PageServiceFinanceComponent;
  let fixture: ComponentFixture<PageServiceFinanceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PageServiceFinanceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PageServiceFinanceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
