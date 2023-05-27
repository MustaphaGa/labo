import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PageCongesComponent } from './page-conges.component';

describe('PageCongesComponent', () => {
  let component: PageCongesComponent;
  let fixture: ComponentFixture<PageCongesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PageCongesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PageCongesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
