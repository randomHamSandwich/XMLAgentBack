import { Component, OnInit } from '@angular/core';
import { AdDTO } from './AdDTO';
import { AdService } from 'src/app/services/ad.service';
import { CarService } from 'src/app/services/car.service';

@Component({
  selector: 'app-ad-create',
  templateUrl: './ad-create.component.html',
  styleUrls: ['./ad-create.component.css']
})
export class AdCreateComponent implements OnInit {

  form: any = {};
  newAd = new AdDTO;
  cars: any;
  
  errorMessage: any;

  constructor(private adService: AdService,
              private carService: CarService) { }

  ngOnInit() {
    this.getAllCars();
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

  onSubmit() {
    this.newAd = new AdDTO();
    this.newAd.startDate = this.form.startDate;
    this.newAd.endDate = this.form.endDate;
    this.newAd.car = this.form.car;

    console.log("start date: " + this.form.startDate);
    console.log("end date: " + this.form.endDate);
    //console.log("car: " + this.form.car);
    
    this.adService.createNewAd(this.newAd).subscribe(
      data => {
        console.log(data);
        this.newAd = data as AdDTO;        
      },
      error => {
        console.log(error);
      }
    );

  }

}
