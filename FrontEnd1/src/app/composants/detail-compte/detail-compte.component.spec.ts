import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailCompteComponent } from './detail-compte.component';

describe('DetailCompteComponent', () => {
  let component: DetailCompteComponent;
  let fixture: ComponentFixture<DetailCompteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailCompteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailCompteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
