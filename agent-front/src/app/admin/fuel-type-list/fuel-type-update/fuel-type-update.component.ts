import { Component, OnInit,Input } from '@angular/core';
import { FuelTypeDTO } from 'src/app/admin/fuel-type-list/FuelTypeDTO';
import { FuelTypeService } from 'src/app/services/fueltype.service';


@Component({
  selector: 'app-fuel-type-update',
  templateUrl: './fuel-type-update.component.html',
  styleUrls: ['./fuel-type-update.component.css']
})
export class FuelTypeUpdateComponent implements OnInit {
  @Input() fuelType: FuelTypeDTO;
  updateFuelType: FuelTypeDTO;
  form: any = {};

  constructor(private fuelTypeService: FuelTypeService) { }

  ngOnInit() {
    this.form.fuelTypeName = this.fuelType.name;

  }

  onSubmit() {
    console.log("onSubmit value of form is: "+ this.form.fuelTypeName );
    
    this.updateFuelType = new FuelTypeDTO();
    this.updateFuelType.name = this.form.fuelTypeName;
    this.updateFuelType.idFuelType = this.fuelType.idFuelType;

    this.fuelTypeService.updateFuelType(
      {
        idGearboxType: this.fuelType.idFuelType,
        name: this.form.fuelTypeName

      }
    )
      .subscribe(
        data => {
          console.log(data);
          this.updateFuelType = data as FuelTypeDTO;
        },
        error => console.log(error)
      );
      // window.location.reload();
  }

}
