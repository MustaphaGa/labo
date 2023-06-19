import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PdfEmployeComponent } from './pdf-employe.component';

describe('PdfEmployeComponent', () => {
  let component: PdfEmployeComponent;
  let fixture: ComponentFixture<PdfEmployeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PdfEmployeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PdfEmployeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
