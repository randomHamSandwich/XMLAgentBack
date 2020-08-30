import { Component, OnInit, Input } from '@angular/core';
import { CarModelDTO } from '../CarModel';
import { CarModelService } from 'src/app/services/carmodel.service';

@Component({
  selector: 'app-car-model-update',
  templateUrl: './car-model-update.component.html',
  styleUrls: ['./car-model-update.component.css']
})
export class CarModelUpdateComponent implements OnInit {
  @Input() carModel: CarModelDTO;
  updateCarModel: CarModelDTO;
  form: any = {};

  constructor(private carModelService: CarModelService) { }

  ngOnInit() {
    this.form.carModelName = this.carModel.name;
  }

  onSubmit() {
    

    this.updateCarModel = new CarModelDTO();
    this.updateCarModel.name = this.form.gearboxTypeName;
    this.updateCarModel.idCarModel = this.carModel.idCarModel;

    this.carModelService.updateCarModel(


      {
        idCarModel: this.carModel.idCarModel,
        name: this.form.carModelName

      }


    )
      .subscribe(
        data => {
          console.log(data);
          this.updateCarModel = data as CarModelDTO;
          window.location.reload();
        },
        error => console.log(error)
      );
      // window.location.reload();


  }

}
