import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FuelTypeAddComponent } from './fuel-type-add.component';

describe('FuelTypeAddComponent', () => {
  let component: FuelTypeAddComponent;
  let fixture: ComponentFixture<FuelTypeAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FuelTypeAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FuelTypeAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
