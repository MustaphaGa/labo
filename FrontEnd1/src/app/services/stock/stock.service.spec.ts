import { TestBed } from '@angular/core/testing';

import { StockServices } from './stock.service';

describe('StockService', () => {
  let service: StockServices;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StockServices);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
