import { TestBed } from '@angular/core/testing';

import { ProduitsSrvService } from './produits-srv.service';

describe('ProduitsSrvService', () => {
  let service: ProduitsSrvService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProduitsSrvService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
