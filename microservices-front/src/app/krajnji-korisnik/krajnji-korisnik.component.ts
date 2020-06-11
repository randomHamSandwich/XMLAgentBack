import { Component, OnInit, Input } from '@angular/core';
import { Korisnik } from '../home/Korisnik';
import { KorisnikService } from '../services/korisnik.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-krajnji-korisnik',
  templateUrl: './krajnji-korisnik.component.html',
  styleUrls: ['./krajnji-korisnik.component.css']
})
export class KrajnjiKorisnikComponent implements OnInit {
  @Input() korisnik: Korisnik

  

  constructor(private router: Router, private korisnikService: KorisnikService) { }

  ngOnInit() {
  }

}
