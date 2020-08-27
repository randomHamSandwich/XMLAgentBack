import { Component, OnInit } from '@angular/core';
import { CarModelDTO } from '../CarModel';
import { CarModelService } from 'src/app/services/carmodel.service';

@Component({
  selector: 'app-car-model-add',
  templateUrl: './car-model-add.component.html',
  styleUrls: ['./car-model-add.component.css']
})
export class CarModelAddComponent implements OnInit {
  form: any = {};
  newCarModel : CarModelDTO;

  constructor(private carModelService: CarModelService) { }

  ngOnInit() {
  }

  onSubmit() {
    this.newCarModel = new CarModelDTO();
    this.newCarModel.name = this.form.carModelName;
    

    this.carModelService.addGearboxType(
      this.newCarModel
    )
      .subscribe(
        data => {
          console.log(data);
          this.newCarModel = data as CarModelDTO;
          window.location.reload();
        },
        error => console.log(error)
      );
    


  }

}
