import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AdService } from 'src/app/services/ad.service';
import { CarService } from 'src/app/services/car.service';
import { AdDTO } from '../ad-create/AdDTO';

@Component({
  selector: 'app-ad-details',
  templateUrl: './ad-details.component.html',
  styleUrls: ['./ad-details.component.css']
})
export class AdDetailsComponent implements OnInit {
  adId: number;
  ad: AdDTO = new AdDTO();

  form: any = {};
  startTime: any;
  endTime: any;

  cars: any;

  errorMessage: any;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private adService: AdService,
              private carService: CarService) { }

  ngOnInit() {
    this.adId = this.route.snapshot.params['idAd'];
    this.getAdById();
   // this.getAllCars();
  }

  getAdById() {
    this.adService.getAdById(this.adId).subscribe(
      data => {
        this.ad = data;
      },
      error => {
        {
          console.log("ERROR, get ad by id: " + error.message);
          
        }
      }
    )
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

  
  onAddToCart() {
    this.startTime = this.form.startDateTime;
    this.endTime = this.form.endDateTime;

    //console.log("startno vreme: " + this.startTime);
    //console.log("krajnje vreme: " + this.endTime);
    
  }

  onBack() {
    this.router.navigate(['/']);
  }
}
