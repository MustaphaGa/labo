import { TestBed } from '@angular/core/testing';

import { BonCommandeServices } from './bon-commande.service';

describe('BonCommandeService', () => {
  let service: BonCommandeServices;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BonCommandeServices);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
