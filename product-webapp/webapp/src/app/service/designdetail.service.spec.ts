import { TestBed } from '@angular/core/testing';

import { DesigndetailService } from './designdetail.service';

describe('DesigndetailService', () => {
  let service: DesigndetailService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DesigndetailService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
