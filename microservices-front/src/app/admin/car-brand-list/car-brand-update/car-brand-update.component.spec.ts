import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarBrandUpdateComponent } from './car-brand-update.component';

describe('CarBrandUpdateComponent', () => {
  let component: CarBrandUpdateComponent;
  let fixture: ComponentFixture<CarBrandUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarBrandUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarBrandUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
