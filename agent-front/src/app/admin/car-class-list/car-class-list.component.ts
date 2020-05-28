import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { CarClassDTO } from './CarClassDTO';
import { CarClassService } from 'src/app/services/carclass.service'

@Component({
  selector: 'app-car-class-list',
  templateUrl: './car-class-list.component.html',
  styleUrls: ['./car-class-list.component.css']
})
export class CarClassListComponent implements OnInit {

  carClass: CarClassDTO; 

  isUpdate: boolean;
  isAdd: boolean;
  carClasses: Observable<CarClassDTO[]>;


  constructor(private carClassService : CarClassService) {
    this.isUpdate = false;
    this.isAdd = false;
   }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.carClasses = this.carClassService.getCarClasses();
  }


  onCarClassUpdate(carClassDTO: CarClassDTO): void {
    console.log("xxxxxxxxxsssssssssssssssxxxxxxxxxxxxxxxxxx________" + carClassDTO.idCarClass
      + " _____" + this.isUpdate);
    this.carClass = carClassDTO;
    this.isUpdate = !this.isUpdate;
    console.log(this.isUpdate);
  }

  onCarClassAdd():void{
    this.isAdd=!this.isAdd;
  }


}
