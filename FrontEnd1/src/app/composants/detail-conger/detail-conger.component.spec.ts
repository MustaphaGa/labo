import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailCongerComponent } from './detail-conger.component';

describe('DetailCongerComponent', () => {
  let component: DetailCongerComponent;
  let fixture: ComponentFixture<DetailCongerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailCongerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailCongerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
