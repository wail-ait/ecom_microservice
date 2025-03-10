import { TestBed } from '@angular/core/testing';

import { AcheteursSrvService } from './acheteursSrv.service';

describe('AcheteursSrvService', () => {
  let service: AcheteursSrvService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AcheteursSrvService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
