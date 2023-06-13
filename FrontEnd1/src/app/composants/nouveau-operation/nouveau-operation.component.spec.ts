import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NouveauOperationComponent } from './nouveau-operation.component';

describe('NouveauOperationComponent', () => {
  let component: NouveauOperationComponent;
  let fixture: ComponentFixture<NouveauOperationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NouveauOperationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NouveauOperationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
