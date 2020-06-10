import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KrajnjiKorisnikComponent } from './krajnji-korisnik.component';

describe('KrajnjiKorisnikComponent', () => {
  let component: KrajnjiKorisnikComponent;
  let fixture: ComponentFixture<KrajnjiKorisnikComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KrajnjiKorisnikComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KrajnjiKorisnikComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
