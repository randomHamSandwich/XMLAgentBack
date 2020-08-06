import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdService } from '../services/ad.service';
import { Observable } from 'rxjs';
import { AdDTO } from './ad-create/AdDTO';
import { CarService } from '../services/car.service';
import { CarDTO } from '../car-create/CarDTO';
import { PricelistService } from '../services/pricelist.service';
import { TokenStorageService } from '../auth/token-storage.service';

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

  constructor(private router: Router,
              private adService: AdService,
              private carService: CarService,
              private pricelistService: PricelistService,
              private tokenStorageService: TokenStorageService) { }

  ngOnInit() {
    this.userID = this.tokenStorageService.getIdKorisnik();
    this.getAllAds();
    this.getAllCars();
    this.getAllPricelists();
  }

  getAllAds() {
    this.ads = this.adService.getAllAds("", "", "");
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
