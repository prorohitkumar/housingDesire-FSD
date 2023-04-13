import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Listofdesigns1Component } from './listofdesigns1.component';

describe('Listofdesigns1Component', () => {
  let component: Listofdesigns1Component;
  let fixture: ComponentFixture<Listofdesigns1Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Listofdesigns1Component ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Listofdesigns1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
