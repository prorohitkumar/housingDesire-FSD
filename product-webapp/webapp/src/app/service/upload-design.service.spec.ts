import { TestBed } from '@angular/core/testing';

import { UploadDesignService } from './upload-design.service';

describe('UploadDesignService', () => {
  let service: UploadDesignService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UploadDesignService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
