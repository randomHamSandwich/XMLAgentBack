import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdUpdateComponent } from './ad-update.component';

describe('AdUpdateComponent', () => {
  let component: AdUpdateComponent;
  let fixture: ComponentFixture<AdUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
