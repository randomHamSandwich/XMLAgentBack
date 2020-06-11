import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdDetailsComponent } from './ad-details.component';

describe('AdDetailsComponent', () => {
  let component: AdDetailsComponent;
  let fixture: ComponentFixture<AdDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
