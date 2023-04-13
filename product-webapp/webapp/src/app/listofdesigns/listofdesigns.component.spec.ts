import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListofdesignsComponent } from './listofdesigns.component';

describe('ListofdesignsComponent', () => {
  let component: ListofdesignsComponent;
  let fixture: ComponentFixture<ListofdesignsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListofdesignsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListofdesignsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
