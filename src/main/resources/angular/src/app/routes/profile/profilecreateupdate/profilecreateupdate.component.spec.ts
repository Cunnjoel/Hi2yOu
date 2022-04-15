import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfilecreateupdateComponent } from './profilecreateupdate.component';

describe('ProfilecreateupdateComponent', () => {
  let component: ProfilecreateupdateComponent;
  let fixture: ComponentFixture<ProfilecreateupdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfilecreateupdateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfilecreateupdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
