import { TestBed } from '@angular/core/testing';

import { VentesSrvService } from './ventes-srv.service';

describe('VentesSrvService', () => {
  let service: VentesSrvService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VentesSrvService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
