import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GearboxListComponent } from './gearbox-list.component';

describe('GearboxListComponent', () => {
  let component: GearboxListComponent;
  let fixture: ComponentFixture<GearboxListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GearboxListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GearboxListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
