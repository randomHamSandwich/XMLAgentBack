import { Component, OnInit } from '@angular/core';
import { FuelTypeDTO } from '../FuelTypeDTO';
import { FuelTypeService } from 'src/app/services/fueltype.service';

@Component({
  selector: 'app-fuel-type-add',
  templateUrl: './fuel-type-add.component.html',
  styleUrls: ['./fuel-type-add.component.css']
})
export class FuelTypeAddComponent implements OnInit {
// fuelTypeName
form: any = {};
newFuelType : FuelTypeDTO;
  constructor(private fuelTypeService : FuelTypeService) { }

  ngOnInit() {
  }


  onSubmit() {
    this.newFuelType = new FuelTypeDTO();
    this.newFuelType.name = this.form.fuelTypeName;

    console.log("xxxxxxxxxx_promenjlva___" +    this.newFuelType.name + "_____forma___"+this.form.gearboxTypeName);
    
    this.fuelTypeService.addFuelType(
      this.newFuelType
    )
      .subscribe(
        data => {
          console.log(data);
          this.newFuelType = data as FuelTypeDTO;
          window.location.reload();
        },
        error => console.log(error)
      );
 


  }
}
