import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewdesignerprofileComponent } from './viewdesignerprofile.component';

describe('ViewdesignerprofileComponent', () => {
  let component: ViewdesignerprofileComponent;
  let fixture: ComponentFixture<ViewdesignerprofileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewdesignerprofileComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewdesignerprofileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
