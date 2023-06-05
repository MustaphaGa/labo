import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PageStockComponent } from './page-stock.component';

describe('PageStockComponent', () => {
  let component: PageStockComponent;
  let fixture: ComponentFixture<PageStockComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PageStockComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PageStockComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
