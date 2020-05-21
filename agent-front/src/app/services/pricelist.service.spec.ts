import { TestBed } from '@angular/core/testing';

import { PricelistService } from './pricelist.service';

describe('PricelistService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PricelistService = TestBed.get(PricelistService);
    expect(service).toBeTruthy();
  });
});
