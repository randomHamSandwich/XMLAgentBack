import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdService } from '../services/ad.service';
import { Observable } from 'rxjs';
import { AdDTO } from './ad-create/AdDTO';
import { CarService } from '../services/car.service';
import { CarDTO } from '../car-create/CarDTO';
import { PricelistService } from '../services/pricelist.service';
import { TokenStorageService } from '../auth/token-storage.service';
import { KorisnikService } from '../services/korisnik.service';
import { EndUser } from '../krajnji-korisnik/EndUserDTO';

@Component({
  selector: 'app-ad',
  templateUrl: './ad.component.html',
  styleUrls: ['./ad.component.css']
})
export class AdComponent implements OnInit {
  isAdd = false;
  ads: Observable<AdDTO[]>;
  cars: any;
  pricelists: any;
  userID: any;

  errorMessage: any;
  isDeleted = false;

  endUserData = new EndUser();

  constructor(private router: Router,
              private adService: AdService,
              private carService: CarService,
              private pricelistService: PricelistService,
              private tokenStorageService: TokenStorageService,
              private userService: KorisnikService) { }

  ngOnInit() {
    this.userID = this.tokenStorageService.getIdKorisnik();
    this.getEndUserData();
    this.getActiveAdsByUser();
    //this.getAllAds();
    this.getAllCars();
    this.getAllPricelists();
  }

  getEndUserData() {
    this.userService.getEndUserData(this.userID).subscribe(
      data => {
        this.endUserData = data;
      },
      error => {
        console.log("Error: " + error.errorMessage);
        
      }
    );
  }

 /* getAllAds() {
    this.ads = this.adService.getAllAds("", "", "");
  }*/

  getActiveAdsByUser() {
    this.adService.getActiveAdsByUser(this.userID).subscribe(
      data => {
        this.ads = data;
      },
      error => {
        console.log("error: " + error.message);
        
      }
    );
  }

  getAllCars() {
    this.carService.getCarsList().subscribe(
      data => {
        this.cars = data;
      },
      error => {
        this.errorMessage = error.error.message;

        console.log("Error: " + this.errorMessage);
      }
    );
  }

  getAllPricelists() {
    this.pricelistService.getAllPricelists().subscribe(
      data => {
        this.pricelists = data;
      },
      error => {
        this.errorMessage = error.error.message;
        console.log("Error: " + this.errorMessage);

      }
    );
  }

  onBack() {
    this.router.navigate(['/']);
  }

  onAdAdd(): void {
    this.isAdd = !this.isAdd;
  }

  onReserve() {
    console.log("DAJ KALENDAR DA REZERVISEM SEBI HEHE");
  }

  onUpdate() {
    console.log("update ad");
    
  }

  onDelete(idAd: any) {
    this.adService.deleteAd(idAd).subscribe(
      data => {
        this.isDeleted = true;
        window.location.reload();
      }
    );
    
  }

}
