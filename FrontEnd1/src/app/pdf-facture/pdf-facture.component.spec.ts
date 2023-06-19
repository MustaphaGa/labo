import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PdfFactureComponent } from './pdf-facture.component';

describe('PdfFactureComponent', () => {
  let component: PdfFactureComponent;
  let fixture: ComponentFixture<PdfFactureComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PdfFactureComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PdfFactureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
