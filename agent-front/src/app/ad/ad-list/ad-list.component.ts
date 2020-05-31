import { Component, OnInit } from '@angular/core';
import { AdDTO } from '../ad-create/AdDTO';
import { Observable } from 'rxjs';
import { AdService } from 'src/app/services/ad.service';
import { CarService } from 'src/app/services/car.service';
import { Router } from '@angular/router';
import { PricelistService } from 'src/app/services/pricelist.service';

@Component({
  selector: 'app-ad-list',
  templateUrl: './ad-list.component.html',
  styleUrls: ['./ad-list.component.css']
})
export class AdListComponent implements OnInit {
  form: any = {};
  ad: AdDTO;
  ads: Observable<AdDTO[]>

  cars: any;
  pricelists: any;
  errorMessage: any;

  constructor(private adService: AdService,
              private carService: CarService,
              private pricelistService: PricelistService,
              private router: Router) { }

  ngOnInit() {
    this.getAllAds();
    this.getAllCars();
    this.getAllPricelists();
  }

  getAllAds() {
    this.ads = this.adService.getAllAds();
  }

  getAllCars() {
    this.carService.getCarsList().subscribe(
      data => {
        this.cars = data;
      },
      error => {
        this.errorMessage = error.error.message;

        console.log("Error: " +  this.errorMessage);
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

  createAd() {
    console.log("creating ad page/form");
    
  }

  onBack() {
    this.router.navigate(['/']);
  }

}
