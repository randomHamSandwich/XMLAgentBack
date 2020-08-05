import { Component, OnInit } from '@angular/core';
import { CarDTO } from './CarDTO';
import { Router } from '@angular/router';
import { CarBrandService } from '../services/carbrand.service';
import { CarModelService } from '../services/carmodel.service';
import { CarClassService } from '../services/carclass.service';
import { GearboxService } from '../services/gearbox.service';
import { FuelTypeService } from '../services/fueltype.service';
import { CarService } from '../services/car.service';
import { TokenStorageService } from '../auth/token-storage.service';
@Component({
  selector: 'app-car-create',
  templateUrl: './car-create.component.html',
  styleUrls: ['./car-create.component.css']
})
export class CarCreateComponent implements OnInit {
  form: any = {};
  newCar = new CarDTO;
  carBrands: any;
  carModels: any;
  carClasses: any;
  gearboxTypes: any;
  fuelTypes: any;
  allowedKM: number;
  km: number;
  country: string;
  city: string;
  street: string;
  streetNumber: string;
  cdw: boolean;
  childrenSeats: number;
  user: number;
  registrationPlate: string;

  errorMessage: any;
  submitted = false;
  constructor(
          private carService: CarService,
          private router: Router,
          private carBrandService: CarBrandService,
          private carModelService: CarModelService,
          private carClassService: CarClassService,
          private gearboxTypeService: GearboxService, 
          private fuelTypeService: FuelTypeService) {}

  ngOnInit() {
    this.getAllCarBrands();
    this.getAllCarModels();
    this.getAllCarClasses();
    this.getAllgearboxTypes();
    this.getAllFuelTypes();
  }

  getAllCarBrands() {
    this.carBrandService.getCarBrands().subscribe(
      data => {
        this.carBrands = data;
      },
      error => {
        this.errorMessage = error.error.message;

        console.log("Error: " +  this.errorMessage);
      }
    );
  }

  getAllCarModels() {
    this.carModelService.getCarModels().subscribe(
      data => {
        this.carModels = data;
      },
      error => {
        this.errorMessage = error.error.message;

        console.log("Error: " +  this.errorMessage);
      }
    );
  }

  getAllCarClasses() {
    this.carClassService.getCarClasses().subscribe(
      data => {
        this.carClasses = data;
      },
      error => {
        this.errorMessage = error.error.message;

        console.log("Error: " +  this.errorMessage);
      }
    );
  }

  getAllgearboxTypes() {
    this.gearboxTypeService.getGearboxs().subscribe(
      data => {
        this.gearboxTypes = data;
      },
      error => {
        this.errorMessage = error.error.message;

        console.log("Error: " +  this.errorMessage);
      }
    );
  }

  getAllFuelTypes() {
    this.fuelTypeService.getFuelTypes().subscribe(
      data => {
        this.fuelTypes = data;
      },
      error => {
        this.errorMessage = error.error.message;

        console.log("Error: " +  this.errorMessage);
      }
    );
  }

  onSubmit() {
    this.submitted = true;
    this.newCar = new CarDTO();
    this.newCar.carBrand = this.form.carBrand;
    this.newCar.carModel = this.form.carModel;
    this.newCar.carClass = this.form.carClass;
    this.newCar.gearboxType = this.form.gearboxType;
    this.newCar.fuelType = this.form.fuelType;
    this.newCar.allowedKM = this.form.allowedKM;
    this.newCar.km = this.form.km;
    this.newCar.country = this.form.country;
    this.newCar.city = this.form.city;
    this.newCar.street = this.form.street;
    this.newCar.streetNumber = this.form.streetNumber;
    this.newCar.cdw = this.form.cdw;
    this.newCar.childrenSeats = this.form.childrenSeats;
    this.newCar.registrationPlate = this.form.registrationPlate;
    this.newCar.user = 3;  

    this.carService.createNewCar(this.newCar).subscribe(
      data => {
        console.log(data);
        this.newCar = data as CarDTO;        
      },
      error => {
        console.log(error);
      }
    );
    
    // window.location.reload();
    
  }
  goBack() {
    this.router.navigate(['/carList']);
  }
  
}