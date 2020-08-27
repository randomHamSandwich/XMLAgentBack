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
import { FileUploader, FileSelectDirective } from 'ng2-file-upload';
import { HttpClient, HttpEventType, HttpResponse } from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';
import { UploadFileService } from '../services/upload-file.service';
import { Observable } from 'rxjs';



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
          private uploadService: UploadFileService,
          private router: Router,
          private carBrandService: CarBrandService,
          private carModelService: CarModelService,
          private carClassService: CarClassService,
          private gearboxTypeService: GearboxService, 
          private fuelTypeService: FuelTypeService,
          private token: TokenStorageService,
          private http: HttpClient) {}

  ngOnInit() {
    this.getAllCarBrands();
    this.getAllCarModels();
    this.getAllCarClasses();
    this.getAllgearboxTypes();
    this.getAllFuelTypes();
    this.userIdFromToken = parseInt(this.token.getIdKorisnik()) ;
    
  }

  selectFile(event) {
    this.selectedFiles = event.target.files;
  }

  upload() {
    this.progress = 0;

    this.currentFile = this.selectedFiles.item(0);
    this.uploadService.upload(this.currentFile, "1").subscribe(
      event => {
        if (event.type === HttpEventType.UploadProgress) {
          this.progress = Math.round(100 * event.loaded / event.total);
        } else if (event instanceof HttpResponse) {
          this.message = event.body.message;
          // this.fileInfos = this.uploadService.getFiles();
        }
      },
      err => {
        this.progress = 0;
        this.message = 'Could not upload the file!';
        this.currentFile = undefined;
      });

    this.selectedFiles = undefined;
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
 

    this.carService.createNewCar(this.newCar).subscribe(
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
