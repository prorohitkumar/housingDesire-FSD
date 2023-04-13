import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UCProfileComponent } from './ucprofile.component';

describe('UCProfileComponent', () => {
  let component: UCProfileComponent;
  let fixture: ComponentFixture<UCProfileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UCProfileComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UCProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
