import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfilecreateComponent } from './profilecreate.component';

describe('ProfilecreateComponent', () => {
  let component: ProfilecreateComponent;
  let fixture: ComponentFixture<ProfilecreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfilecreateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfilecreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
