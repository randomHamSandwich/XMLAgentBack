import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarBrandAddComponent } from './car-brand-add.component';

describe('CarBrandAddComponent', () => {
  let component: CarBrandAddComponent;
  let fixture: ComponentFixture<CarBrandAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarBrandAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarBrandAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
