import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from './auth/token-storage.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  private roles: string[];
  private authority: string;
  

  constructor(private tokenStorage: TokenStorageService) { }

  logout() {
    this.tokenStorage.signOut();
    window.location.reload();
  }
  

  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      this.roles = this.tokenStorage.getAuthorities();
      this.roles.every(role => {

         if (role === 'ADMIN') {
          this.authority = 'ad';
          return false;
        }

        else if (role === 'AGENT') {
          this.authority = 'ag';
          return false;
        } 
        
        else if (role === 'KORISNIK_OGRANI_PRISTUP') {
          this.authority = 'kop';
          return false;
        }
        
        else if (role === 'KORISNIK_ZABRANJEN') {
          this.authority = 'kz';
          return false;
        }
// else if (role === 'KORISNIK')
        this.authority = 'user';
        return true;
      });
    }
  }
}
