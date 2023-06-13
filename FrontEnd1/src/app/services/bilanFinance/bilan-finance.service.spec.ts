import { TestBed } from '@angular/core/testing';

import { BilanFinanceService } from './bilan-finance.service';

describe('BilanFinanceService', () => {
  let service: BilanFinanceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BilanFinanceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
