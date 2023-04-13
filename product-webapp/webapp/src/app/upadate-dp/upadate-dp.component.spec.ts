import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpadateDpComponent } from './upadate-dp.component';

describe('UpadateDpComponent', () => {
  let component: UpadateDpComponent;
  let fixture: ComponentFixture<UpadateDpComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpadateDpComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpadateDpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
