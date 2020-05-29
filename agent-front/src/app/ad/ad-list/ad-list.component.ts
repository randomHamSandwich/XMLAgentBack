import { Component, OnInit } from '@angular/core';
import { AdDTO } from '../ad-create/AdDTO';
import { Observable } from 'rxjs';
import { AdService } from 'src/app/services/ad.service';
import { CarService } from 'src/app/services/car.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ad-list',
  templateUrl: './ad-list.component.html',
  styleUrls: ['./ad-list.component.css']
})
export class AdListComponent implements OnInit {
  ad: AdDTO;
  ads: Observable<AdDTO[]>

  cars: any;
  errorMessage: any;

  constructor(private adService: AdService,
              private carService: CarService,
              private router: Router) { }

  ngOnInit() {
    this.findAllAds();
    this.getAllCars();
  }

  findAllAds() {
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

  createAd() {
    console.log("creating ad page/form");
    
  }

  navigate() {
    this.router.navigate(['/']);
  }

  onBack() {
    this.router.navigate(['/']);
  }

}
