import { Component, OnInit } from '@angular/core';
import { Korisnik } from 'src/app/home/Korisnik';
import { Observable } from 'rxjs';
import { KorisnikService } from 'src/app/services/korisnik.service';

@Component({
  selector: 'app-change-authoriy',
  templateUrl: './change-authoriy.component.html',
  styleUrls: ['./change-authoriy.component.css']
})
export class ChangeAuthoriyComponent implements OnInit {

  korisnici: Observable<Korisnik[]>;
  constructor(private korisnikService: KorisnikService) { }

  ngOnInit() {



    this.reloadData();
  }

  reloadData() {
    this.korisnici = this.korisnikService.getAllKorisnik()


  }

}
