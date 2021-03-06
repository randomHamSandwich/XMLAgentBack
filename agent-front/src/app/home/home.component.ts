import { Component, OnInit } from '@angular/core';

import { TokenStorageService } from '../auth/token-storage.service';
import { Observable } from 'rxjs';
import { Korisnik } from './Korisnik';
import { KorisnikService } from '../services/korisnik.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  info: any;
  private roles: string[];
  private authority: string;
  korisnik:Observable<Korisnik>
  constructor(private token: TokenStorageService, private korisnikService: KorisnikService) { }

  ngOnInit() {
    this.info = {
      token: this.token.getToken(),
      username: this.token.getUsername(),
      authorities: this.token.getAuthorities(),
    
    };

    if (this.token.getToken()) {
      this.roles = this.token.getAuthorities();
      this.roles.every(role => {

         if (role === 'ADMIN') {
          this.authority = 'admin';
          return false;
        }

        else if (role === 'AGENT') {
          this.authority = 'agent';
          return false;
        } 
        
        else if (role === 'END_USER_LIMITED_ACCESS') {
          this.authority = 'end_user_limited_access';
          return false;
        }
        
        else if (role === 'END_USER_FORBIDDEN') {
          this.authority = 'end_user_forbidden';
          return false;
        }
        else if (role === 'END_USER')
        this.authority = 'end_user';
        return true;
      });
    }
    this.reloadData();
  }

  logout() {
    this.token.signOut();
    window.location.reload();
  }

  reloadData() {
    this.korisnik = this.korisnikService.getKorisnik(this.token.getIdKorisnik());

  }
}
