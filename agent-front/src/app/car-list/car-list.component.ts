import { Component, OnInit } from '@angular/core';
import { CarService } from '../services/car.service';
import { Router } from '@angular/router';
import { CarDTO } from '../car-create/CarDTO';
import { CarDetailsComponent } from '../car-details/car-details.component';
import { TokenStorageService } from 'src/app/auth/token-storage.service';

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
  userId: number;
  isDeleted: any;
  isDeleteError: any;

  constructor(private carService: CarService,
              private router: Router,
              private carDetailsComponent: CarDetailsComponent,
              private tokenService: TokenStorageService) 
              { 
                this.car = new CarDTO;
                this.car.carBrand = "zastava";
              }

  ngOnInit() {
    this.userId = +this.tokenService.getIdKorisnik();
    this.findAllCars();
  }

  findAllCars() {
          
      this.carService.getCarsOwndByUser(this.userId).subscribe(
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
    this.carDetailsComponent.ngOnInit();
    this.router.navigate(['/carDetails', {idCar: this.car.idCar}]);
  }
  onEdit(c) {
    this.car=c;
    this.carDetailsComponent.ngOnInit();
    this.router.navigate(['/carEdit', {idCar: this.car.idCar}]);
  }

  onDelete(c) {
    this.carService.deleteCar(c.idCar).subscribe(
      data => {
        this.isDeleted = true;
        window.location.reload();
      },
      error => {
        this.isDeleteError = true;
        console.log("error: " + error.error.message);
        
      }
    );
    // window.location.reload();
  }


  returnCar() {
    return this.car;
  }

}
