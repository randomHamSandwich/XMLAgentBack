import { Component, OnInit,Input } from '@angular/core';
import { CarBrandDTO } from '../CarBrandDTO';
import { CarBrandService } from 'src/app/services/carbrand.service';

@Component({
  selector: 'app-car-brand-update',
  templateUrl: './car-brand-update.component.html',
  styleUrls: ['./car-brand-update.component.css']
})
export class CarBrandUpdateComponent implements OnInit {
  @Input() carBrand:CarBrandDTO;
  updateCarBrand: CarBrandDTO;
  form: any = {};

  constructor( private carBrandService: CarBrandService) { }

  ngOnInit() {
    this.form.carBrandName = this.carBrand.name;
  }

  onSubmit() {
    console.log("onSubmit value of form is: "+ this.form.gearboxTypeName );
    
    this.updateCarBrand = new CarBrandDTO();
    this.updateCarBrand.name = this.form.gearboxTypeName;
    this.updateCarBrand.idCarBrand = this.carBrand.idCarBrand;

    this.carBrandService.updateCarBrand(


      {
        idGearboxType: this.carBrand.idCarBrand,
        name: this.form.carBrandName

      }


    )
      .subscribe(
        data => {
          console.log(data);
          this.updateCarBrand = data as CarBrandDTO;
        },
        error => console.log(error)
      );
      window.location.reload();


  }


}
