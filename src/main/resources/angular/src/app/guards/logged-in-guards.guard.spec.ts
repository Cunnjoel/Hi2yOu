import { TestBed } from '@angular/core/testing';

import { LoggedInGuardsGuard } from './logged-in-guards.guard';

describe('LoggedInGuardsGuard', () => {
  let guard: LoggedInGuardsGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(LoggedInGuardsGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
