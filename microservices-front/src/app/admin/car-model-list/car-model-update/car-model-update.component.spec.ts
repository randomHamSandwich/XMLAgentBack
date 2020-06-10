import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarModelUpdateComponent } from './car-model-update.component';

describe('CarModelUpdateComponent', () => {
  let component: CarModelUpdateComponent;
  let fixture: ComponentFixture<CarModelUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarModelUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarModelUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
