import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PageOperationComponent } from './page-operation.component';

describe('PageOperationComponent', () => {
  let component: PageOperationComponent;
  let fixture: ComponentFixture<PageOperationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PageOperationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PageOperationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
