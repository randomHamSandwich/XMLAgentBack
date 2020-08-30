import { Component, OnInit } from '@angular/core';
import { CarService } from '../services/car.service';
import { Router } from '@angular/router';
import { CarDTO } from '../car-create/CarDTO';
import { CarDetailsComponent } from '../car-details/car-details.component';

@Component({
  selector: 'app-car-list',
  templateUrl: './car-list.component.html',
  styleUrls: ['./car-list.component.css'],
  providers: [CarDetailsComponent]
})
export class CarListComponent implements OnInit {
  cars: any;
  car: CarDTO;
  errorMessage: any;

  constructor(private carService: CarService,
              private router: Router,
              private carDetailsComponent: CarDetailsComponent
              ) 
              { 
                this.car = new CarDTO;
                this.car.carBrand = "zastava";
              }

  ngOnInit() {
    this.findAllCars();
  }

  findAllCars() {
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

  onBack() {
    this.router.navigate(['/']);
  }

  onDetails(c) {
    this.car=c;
    // this.carDetailsComponent.fillACar(this.car);
    this.carDetailsComponent.ngOnInit();
    this.router.navigate(['/carDetails', {idCar: this.car.idCar}]);
  }


  returnCar() {
    return this.car;
  }

}
