import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarBrandListComponent } from './car-brand-list.component';

describe('CarBrandListComponent', () => {
  let component: CarBrandListComponent;
  let fixture: ComponentFixture<CarBrandListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarBrandListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarBrandListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
