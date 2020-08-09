import { Component, OnInit } from '@angular/core';
import { AdDTO } from './AdDTO';
import { AdService } from 'src/app/services/ad.service';
import { CarService } from 'src/app/services/car.service';
import { PricelistService } from 'src/app/services/pricelist.service';
import { Router } from '@angular/router';
import { TokenStorageService } from 'src/app/auth/token-storage.service';

@Component({
  selector: 'app-ad-create',
  templateUrl: './ad-create.component.html',
  styleUrls: ['./ad-create.component.css']
})
export class AdCreateComponent implements OnInit {

  form: any = {};
  newAd = new AdDTO;
  cars: any;
  pricelists: any;
  
  errorMessage: any;
  submitted = false ;

  ads: any;
  userId: number;

  constructor(private adService: AdService,
              private carService: CarService,
              private pricelistService: PricelistService,
              private tokenService: TokenStorageService,
              private router: Router) { }

  ngOnInit() {
    this.userId = +this.tokenService.getIdKorisnik();
    this.getAllCars();
    this.getAllPricelists();
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
        this.errorMessage = error.error.errorMessage;
        console.log("Error: " + this.errorMessage);
      }
    );
  }

  onSubmit() {
    this.submitted = true;

    this.newAd = new AdDTO();
    this.newAd.startDate = this.form.startDate;
    this.newAd.endDate = this.form.endDate;
    this.newAd.pricelist = this.form.pricelist;
    this.newAd.car = this.form.car;
    this.newAd.user = this.userId;
    
    this.adService.createNewAd(this.newAd).subscribe(
      data => {
        console.log(data);
        this.newAd = data as AdDTO;        
      },
      error => {
        console.log(error);
      }
    );

    this.navigate();
  }

  navigate() {
    this.router.navigate(['/ads-dashboard']);
  }

  goBack() {
    //window.location.reload();
    this.router.navigate(['/ads-dashboard']);
  }

}
