import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PricelistCreateComponent } from './pricelist-create.component';

describe('PricelistCreateComponent', () => {
  let component: PricelistCreateComponent;
  let fixture: ComponentFixture<PricelistCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PricelistCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PricelistCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
