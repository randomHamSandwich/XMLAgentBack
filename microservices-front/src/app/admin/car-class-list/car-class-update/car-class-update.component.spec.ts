import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarClassUpdateComponent } from './car-class-update.component';

describe('CarClassUpdateComponent', () => {
  let component: CarClassUpdateComponent;
  let fixture: ComponentFixture<CarClassUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarClassUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarClassUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
