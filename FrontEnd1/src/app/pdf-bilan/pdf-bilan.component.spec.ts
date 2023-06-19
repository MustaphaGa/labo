import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PdfBilanComponent } from './pdf-bilan.component';

describe('PdfBilanComponent', () => {
  let component: PdfBilanComponent;
  let fixture: ComponentFixture<PdfBilanComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PdfBilanComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PdfBilanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
