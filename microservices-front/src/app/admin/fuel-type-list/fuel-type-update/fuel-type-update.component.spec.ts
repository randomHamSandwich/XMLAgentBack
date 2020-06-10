import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FuelTypeUpdateComponent } from './fuel-type-update.component';

describe('FuelTypeUpdateComponent', () => {
  let component: FuelTypeUpdateComponent;
  let fixture: ComponentFixture<FuelTypeUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FuelTypeUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FuelTypeUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
