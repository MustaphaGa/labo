import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailMouvementComponent } from './detail-mouvement.component';

describe('DetailMouvementComponent', () => {
  let component: DetailMouvementComponent;
  let fixture: ComponentFixture<DetailMouvementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailMouvementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailMouvementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
