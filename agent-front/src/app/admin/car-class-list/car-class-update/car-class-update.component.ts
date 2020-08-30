import { Component, OnInit,Input } from '@angular/core';
import { CarClassDTO } from '../CarClassDTO';
import { CarClassService } from 'src/app/services/carclass.service';

@Component({
  selector: 'app-car-class-update',
  templateUrl: './car-class-update.component.html',
  styleUrls: ['./car-class-update.component.css']
})
export class CarClassUpdateComponent implements OnInit {
  @Input() carClass: CarClassDTO;
  updateCarClass: CarClassDTO;
  form: any = {};

  constructor(private carClassService: CarClassService) { }

  ngOnInit() {
    this.form.carClassName = this.carClass.name;
  }

  onSubmit() {
    console.log("onSubmit value of form is: "+ this.form.gearboxTypeName );
    
    this.updateCarClass = new CarClassDTO();
    this.updateCarClass.name = this.form.gearboxTypeName;
    this.updateCarClass.idCarClass = this.carClass.idCarClass;

    this.carClassService.updateCarClass(


      {
        idGearboxType: this.carClass.idCarClass,
        name: this.form.carClassName

      }


    )
      .subscribe(
        data => {
          console.log(data);
          this.updateCarClass = data as CarClassDTO;
          window.location.reload();
        },
        error => console.log(error)
      );
      // window.location.reload();


  }

}
