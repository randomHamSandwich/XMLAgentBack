import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PricelistUpdateComponent } from './pricelist-update.component';

describe('PricelistUpdateComponent', () => {
  let component: PricelistUpdateComponent;
  let fixture: ComponentFixture<PricelistUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PricelistUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PricelistUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
