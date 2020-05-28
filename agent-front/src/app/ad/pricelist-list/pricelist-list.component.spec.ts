import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PricelistListComponent } from './pricelist-list.component';

describe('PricelistListComponent', () => {
  let component: PricelistListComponent;
  let fixture: ComponentFixture<PricelistListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PricelistListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PricelistListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
