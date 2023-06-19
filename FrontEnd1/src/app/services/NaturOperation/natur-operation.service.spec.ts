import { TestBed } from '@angular/core/testing';

import { NaturOperationService } from './natur-operation.service';

describe('NaturOperationService', () => {
  let service: NaturOperationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NaturOperationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
