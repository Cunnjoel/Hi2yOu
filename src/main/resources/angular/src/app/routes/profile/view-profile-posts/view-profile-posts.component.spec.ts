import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewProfilePostsComponent } from './view-profile-posts.component';

describe('ViewProfilePostsComponent', () => {
  let component: ViewProfilePostsComponent;
  let fixture: ComponentFixture<ViewProfilePostsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewProfilePostsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewProfilePostsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
