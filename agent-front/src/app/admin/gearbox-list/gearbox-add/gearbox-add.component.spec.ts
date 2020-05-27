import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GearboxAddComponent } from './gearbox-add.component';

describe('GearboxAddComponent', () => {
  let component: GearboxAddComponent;
  let fixture: ComponentFixture<GearboxAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GearboxAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GearboxAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
