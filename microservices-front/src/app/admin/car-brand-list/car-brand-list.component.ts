import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { CarBrandDTO } from './CarBrandDTO';
import { CarBrandService } from 'src/app/services/carbrand.service';

@Component({
  selector: 'app-car-brand-list',
  templateUrl: './car-brand-list.component.html',
  styleUrls: ['./car-brand-list.component.css']
})
export class CarBrandListComponent implements OnInit {

  carBrand: CarBrandDTO;

  isUpdate: boolean;
  isAdd: boolean;
  carBrands: Observable<CarBrandDTO[]>;



  constructor(private carBrandService: CarBrandService) {
    this.isUpdate = false;
    this.isAdd = false;
  }

  ngOnInit() {
    this.reloadData();
  }
  reloadData() {
    this.carBrands = this.carBrandService.getCarBrands();
  }

  onCarBrandUpdate(carBrandDTO: CarBrandDTO): void {
    console.log("xxxxxxxxxsssssssssssssssxxxxxxxxxxxxxxxxxx________" + carBrandDTO.idCarBrand
      + " _____" + this.isUpdate);
    this.carBrand = carBrandDTO;
    this.isUpdate = !this.isUpdate;
    console.log(this.isUpdate);
  }

  onCarBrandDelete(carBrand: CarBrandDTO): void {
    this.carBrandService.deleteCarBrand(carBrand)
    .subscribe(
      data => {
        console.log(data);
        // gear = data as GearboxTypeDTO;
      },
      error => console.log(error)
    );
    window.location.reload();
  }
  
  onCarBrandAdd(): void {
    this.isAdd = !this.isAdd;
  }





}
