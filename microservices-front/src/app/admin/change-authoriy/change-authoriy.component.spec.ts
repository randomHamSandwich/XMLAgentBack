import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChangeAuthoriyComponent } from './change-authoriy.component';

describe('ChangeAuthoriyComponent', () => {
  let component: ChangeAuthoriyComponent;
  let fixture: ComponentFixture<ChangeAuthoriyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChangeAuthoriyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChangeAuthoriyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
