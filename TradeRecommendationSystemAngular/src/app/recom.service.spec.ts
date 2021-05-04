import { TestBed } from '@angular/core/testing';

import { RecomService } from './recom.service';

describe('RecomService', () => {
  let service: RecomService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RecomService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
