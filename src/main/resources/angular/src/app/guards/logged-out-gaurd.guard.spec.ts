import { TestBed } from '@angular/core/testing';

import { LoggedOutGaurdGuard } from './logged-out-gaurd.guard';

describe('LoggedOutGaurdGuard', () => {
  let guard: LoggedOutGaurdGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(LoggedOutGaurdGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
