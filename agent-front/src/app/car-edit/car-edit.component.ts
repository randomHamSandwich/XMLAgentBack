import { Component, OnInit } from '@angular/core';
import { CarDTO } from '../car-create/CarDTO';
import { ActivatedRoute, Router } from '@angular/router';
import { CarBrandService } from '../services/carbrand.service';
import { CarModelService } from '../services/carmodel.service';
import { CarClassService } from '../services/carclass.service';
import { GearboxService } from '../services/gearbox.service';
import { FuelTypeService } from '../services/fueltype.service';
import { CarService } from '../services/car.service';
import { TokenStorageService } from '../auth/token-storage.service';
import { FileUploader, FileSelectDirective } from 'ng2-file-upload';
import { HttpClient, HttpEventType, HttpResponse } from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';
import { UploadFileService } from '../services/upload-file.service';
import { Observable } from 'rxjs';
import { FormGroup, FormControl} from '@angular/forms'

@Component({
  selector: 'app-car-edit',
  templateUrl: './car-edit.component.html',
  styleUrls: ['./car-edit.component.css']
})
export class CarEditComponent implements OnInit {

    car: CarDTO = new CarDTO();
    idCar: string;
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
    userIdFromToken: number;
    photos: any = null;
    selectedFile: File = null;
    binary: File;
    bstring: string;
    fileReader = new FileReader();
    selectedFiles: FileList;
    currentFile: File;
    progress = 0;
    message = '';
   
    errorMessage: any;
    submitted = false;
    constructor(
            private carService: CarService,
            private router: Router,
            private route: ActivatedRoute,
            private carBrandService: CarBrandService,
            private carModelService: CarModelService,
            private carClassService: CarClassService,
            private gearboxTypeService: GearboxService, 
            private fuelTypeService: FuelTypeService,
            private token: TokenStorageService,) {}
  
    ngOnInit() {
      this.route.paramMap.subscribe(params => { this.idCar = params.get("idCar"); })
      this.getCarById();
      this.getAllCarBrands();
      this.getAllCarModels();
      this.getAllCarClasses();
      this.getAllgearboxTypes();
      this.getAllFuelTypes();
      this.userIdFromToken = parseInt(this.token.getIdKorisnik());
      
    }

    fillTheFields(){
      for (let entry of this.carBrands) {
         if (entry.name == this.car.carBrand) this.form.carBrand = entry;
      }
      for (let entry of this.carModels) {
        if (entry.name == this.car.carModel) this.form.carModel = entry;
      }
      for (let entry of this.carClasses) {
        if (entry.name == this.car.carClass) this.form.carClasses = entry;
      }
      for (let entry of this.gearboxTypes) {
        if (entry.name == this.car.gearboxType) this.form.gearboxType = entry;
      }
      for (let entry of this.fuelTypes) {
        if (entry.name == this.car.fuelType) this.form.fuelType = entry;
      }
      this.form.km = this.car.km;
      this.form.allowedKM = this.car.allowedKM;
      this.form.country = this.car.country;
      this.form.city = this.car.city;
      this.form.street = this.car.street;
      this.form.streetNumber = this.car.streetNumber;
      this.form.cdw = this.car.cdw;
      this.form.childrenSeats = this.car.childrenSeats;
      this.form.registrationPlate = this.car.registrationPlate;
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
      this.newCar.user = this.userIdFromToken;
   
  
      this.carService.editCar(this.newCar, this.idCar).subscribe(
        data => {
          console.log(data);
          this.newCar = data as CarDTO;        
        },
        error => {
          console.log(error);
        }
      );
    
    }
    goBack() {
      this.router.navigate(['/carList']);
    }

    getCarById() {
      this.carService.getCarById(this.idCar).subscribe(
        data => {
          this.car = data;
        },
        error => {
          {
            console.log("ERROR getCarById: " + error.errorMessage);
            
          }
        }
      )
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
  
  }
  