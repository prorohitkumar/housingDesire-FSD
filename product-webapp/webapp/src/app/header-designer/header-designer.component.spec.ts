import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderDesignerComponent } from './header-designer.component';

describe('HeaderDesignerComponent', () => {
  let component: HeaderDesignerComponent;
  let fixture: ComponentFixture<HeaderDesignerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HeaderDesignerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HeaderDesignerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
