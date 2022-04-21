import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddlikesComponent } from './addlikes.component';

describe('AddlikesComponent', () => {
  let component: AddlikesComponent;
  let fixture: ComponentFixture<AddlikesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddlikesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddlikesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
