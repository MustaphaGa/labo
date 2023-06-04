import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailRecrutemntComponent } from './detail-recrutemnt.component';

describe('DetailRecrutemntComponent', () => {
  let component: DetailRecrutemntComponent;
  let fixture: ComponentFixture<DetailRecrutemntComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailRecrutemntComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailRecrutemntComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
