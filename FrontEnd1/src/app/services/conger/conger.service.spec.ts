import { TestBed } from '@angular/core/testing';

import { CongerService } from './conger.service';

describe('CongerService', () => {
  let service: CongerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CongerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
