import { Component, OnInit, Input } from '@angular/core';
import { GearboxTypeDTO } from 'src/app/admin/gearbox-list/GearboxTypeDTO';
import { GearboxService } from 'src/app/services/gearbox.service';

@Component({
  selector: 'app-gearbox',
  templateUrl: './gearbox.component.html',
  styleUrls: ['./gearbox.component.css']
})
export class GearboxComponent implements OnInit {
  @Input() gearBoxType: GearboxTypeDTO;
  updateGearBoxType: GearboxTypeDTO;
  form: any = {};

  constructor(private gearboxService: GearboxService) { }

  ngOnInit() {
    this.form.gearboxTypeName = this.gearBoxType.name;
  }

  onSubmit() {
    console.log("onSubmit value of form is: "+ this.form.gearboxTypeName );
    
    this.updateGearBoxType = new GearboxTypeDTO();
    this.updateGearBoxType.name = this.form.gearboxTypeName;
    this.updateGearBoxType.idGearboxType = this.gearBoxType.idGearboxType;

    this.gearboxService.updateGearboxType(


      {
        idGearboxType: this.gearBoxType.idGearboxType,
        name: this.form.gearboxTypeName

      }


    )
      .subscribe(
        data => {
          console.log(data);
          this.updateGearBoxType = data as GearboxTypeDTO;
        },
        error => console.log(error)
      );
      window.location.reload();


  }

}
