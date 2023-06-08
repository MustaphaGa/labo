import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CongerDetailComponent } from './conger-detail.component';

describe('CongerDetailComponent', () => {
  let component: CongerDetailComponent;
  let fixture: ComponentFixture<CongerDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CongerDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CongerDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
