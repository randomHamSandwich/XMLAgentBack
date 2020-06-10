import { Component, OnInit } from '@angular/core';
import { GearboxService } from 'src/app/services/gearbox.service';
import { GearboxTypeDTO } from '../GearboxTypeDTO';

@Component({
  selector: 'app-gearbox-add',
  templateUrl: './gearbox-add.component.html',
  styleUrls: ['./gearbox-add.component.css']
})
export class GearboxAddComponent implements OnInit {
  form: any = {};
  newGearboxType : GearboxTypeDTO;
  constructor(private gearboxService: GearboxService) { }
  ngOnInit() {
  }


  onSubmit() {
    this.newGearboxType = new GearboxTypeDTO();
    this.newGearboxType.name = this.form.gearboxTypeName;

    console.log("xxxxxxxxxx_promenjlva___" +    this.newGearboxType.name + "_____forma___"+this.form.gearboxTypeName);
    
    this.gearboxService.addGearboxType(
      this.newGearboxType
    )
      .subscribe(
        data => {
          console.log(data);
          this.newGearboxType = data as GearboxTypeDTO;
        },
        error => console.log(error)
      );
      window.location.reload();


  }


}
