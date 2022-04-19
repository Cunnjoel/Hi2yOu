import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardcreatepostComponent } from './dashboardcreatepost.component';

describe('DashboardcreatepostComponent', () => {
  let component: DashboardcreatepostComponent;
  let fixture: ComponentFixture<DashboardcreatepostComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DashboardcreatepostComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DashboardcreatepostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
