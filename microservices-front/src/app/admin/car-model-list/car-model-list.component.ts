import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { CarModelDTO } from './CarModel';
import { CarModelService } from 'src/app/services/carmodel.service';

@Component({
  selector: 'app-car-model-list',
  templateUrl: './car-model-list.component.html',
  styleUrls: ['./car-model-list.component.css']
})
export class CarModelListComponent implements OnInit {

  carModel : CarModelDTO;

  isUpdate: boolean;
  isAdd: boolean;
  carModels: Observable<CarModelDTO[]>;

  constructor(private carModelService: CarModelService) {
    this.isUpdate = false;
    this.isAdd = false;
   }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.carModels = this.carModelService.getCarModels();
  }

  onCarModelUpdate(carModelDTO: CarModelDTO): void {

    this.carModel = carModelDTO;
    this.isUpdate = !this.isUpdate;

  }

  onCarModelDelete(carModel: CarModelDTO): void {
    this.carModelService.deleteCarModel(carModel)
    .subscribe(
      data => {
        console.log(data);
        // gear = data as GearboxTypeDTO;
      },
      error => console.log(error)
    );
    window.location.reload();
  }

  onCarModelAdd():void{
    this.isAdd=!this.isAdd;
  }



}
