import { Component, OnInit } from '@angular/core';
import { CarService } from '../services/car.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-car-list',
  templateUrl: './car-list.component.html',
  styleUrls: ['./car-list.component.css']
})
export class CarListComponent implements OnInit {
  car: any;
  errorMessage: any;

  constructor(private carService: CarService,
              private router: Router) { }

  ngOnInit() {
    this.findAllDiscounts();
  }

  findAllDiscounts() {
    this.carService.getCarsList().subscribe(
      data => {
        this.car = data;
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


}
