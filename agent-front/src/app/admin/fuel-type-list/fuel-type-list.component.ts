import { Component, OnInit } from '@angular/core';
import { FuelTypeDTO } from './FuelTypeDTO';
import { Observable } from 'rxjs';
import { FuelTypeService } from 'src/app/services/fueltype.service';

@Component({
  selector: 'app-fuel-type-list',
  templateUrl: './fuel-type-list.component.html',
  styleUrls: ['./fuel-type-list.component.css']
})
export class FuelTypeListComponent implements OnInit {

  fuelType : FuelTypeDTO;

  isUpdate: boolean;
  isAdd: boolean;

  fuelTypes: Observable<FuelTypeDTO[]>;

  constructor(private fuelTypeService: FuelTypeService) { 
    this.isUpdate= false;
    this.isAdd = false;


  }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {

    this.fuelTypes = this.fuelTypeService.getFuelTypes();

  }
  onFuelTypeUpdate(ft: FuelTypeDTO): void {
    console.log("xxxxxxxxxsssssssssssssssxxxxxxxxxxxxxxxxxx________" + ft.idFuelType
      + " _____" + this.isUpdate);
    this.fuelType = ft;
    this.isUpdate = !this.isUpdate;
    console.log(this.isUpdate);
  }

  onFuelTypeAdd():void{
    this.isAdd=!this.isAdd;
  }
}
