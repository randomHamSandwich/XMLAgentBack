import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarClassAddComponent } from './car-class-add.component';

describe('CarClassAddComponent', () => {
  let component: CarClassAddComponent;
  let fixture: ComponentFixture<CarClassAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarClassAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarClassAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
