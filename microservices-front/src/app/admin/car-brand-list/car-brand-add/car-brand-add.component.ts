import { Component, OnInit } from '@angular/core';
import { CarBrandDTO } from '../CarBrandDTO';
import { CarBrandService } from 'src/app/services/carbrand.service';

@Component({
  selector: 'app-car-brand-add',
  templateUrl: './car-brand-add.component.html',
  styleUrls: ['./car-brand-add.component.css']
})
export class CarBrandAddComponent implements OnInit {

  form: any = {};
  newCarBrand : CarBrandDTO;
  constructor(private carBrandService: CarBrandService) { }


  ngOnInit() {
  }

  
  onSubmit() {
    this.newCarBrand = new CarBrandDTO();
    this.newCarBrand.name = this.form.carBrandName;

    console.log("xxxxxxxxxx_promenjlva___" +    this.newCarBrand.name + "_____forma___"+this.form.gearboxTypeName);
    
    this.carBrandService.addCarBrand(
      this.newCarBrand
    )
      .subscribe(
        data => {
          console.log(data);
          this.newCarBrand = data as CarBrandDTO;
        },
        error => console.log(error)
      );
      window.location.reload();


  }


}
