import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PageBilanFinancierComponent } from './page-bilan-financier.component';

describe('PageBilanFinancierComponent', () => {
  let component: PageBilanFinancierComponent;
  let fixture: ComponentFixture<PageBilanFinancierComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PageBilanFinancierComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PageBilanFinancierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
