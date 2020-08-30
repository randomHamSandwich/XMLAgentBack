import { Component, OnInit } from '@angular/core';
import { CarClassDTO } from '../CarClassDTO';
import { CarClassService } from 'src/app/services/carclass.service';

@Component({
  selector: 'app-car-class-add',
  templateUrl: './car-class-add.component.html',
  styleUrls: ['./car-class-add.component.css']
})
export class CarClassAddComponent implements OnInit {
  // 
  form: any = {};
  newCarClassName: CarClassDTO;
  constructor(private carClassService: CarClassService) { }

  ngOnInit() {
  }

  onSubmit() {
    this.newCarClassName = new CarClassDTO();
    this.newCarClassName.name = this.form.carClassName;

    console.log("xxxxxxxxxx_promenjlva___" + this.newCarClassName.name + "_____forma___" + this.form.carClassName);

    this.carClassService.addCarClass(
      this.newCarClassName
    )
      .subscribe(
        data => {
          console.log(data);
          this.newCarClassName = data as CarClassDTO;
          window.location.reload();
        },
        error => console.log(error)
      );
    // window.location.reload();


  }

}
