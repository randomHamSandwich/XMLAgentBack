import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AdService } from 'src/app/services/ad.service';
import { CarService } from 'src/app/services/car.service';
import { Observable } from 'rxjs';
import { AdDTO } from '../ad-create/AdDTO';

@Component({
  selector: 'app-ad-details',
  templateUrl: './ad-details.component.html',
  styleUrls: ['./ad-details.component.css']
})
export class AdDetailsComponent implements OnInit {
  adId: number;
  ad: Observable<AdDTO>;

  errorMessage: any;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private adService: AdService,
              private carService: CarService) { }

  ngOnInit() {
    this.adId = this.route.snapshot.params['idAd'];
    this.getAdById();
  }

  getAdById() {
    this.adService.getAdById(this.adId).subscribe(
      data => {
        this.ad = data;
      },
      error => {
        this.errorMessage = error.error.errorMessage;
        console.log("Error: " + error);
        
      }
    );
  }

  getCarById() {
    // geting car data
  }
  
  onBack() {

  }
}
