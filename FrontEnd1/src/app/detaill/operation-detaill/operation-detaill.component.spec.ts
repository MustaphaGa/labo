import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OperationDetaillComponent } from './operation-detaill.component';

describe('OperationDetaillComponent', () => {
  let component: OperationDetaillComponent;
  let fixture: ComponentFixture<OperationDetaillComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OperationDetaillComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OperationDetaillComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
