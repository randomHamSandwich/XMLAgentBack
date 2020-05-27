import { Component, OnInit, Input } from '@angular/core';
import { Observable } from 'rxjs';
import { GearboxService } from 'src/app/services/gearbox.service';
import { GearboxTypeDTO } from 'src/app/admin/gearbox-list/GearboxTypeDTO'

@Component({
  selector: 'app-gearbox-list',
  templateUrl: './gearbox-list.component.html',
  styleUrls: ['./gearbox-list.component.css']
})
export class GearboxListComponent implements OnInit {

  gearBoxType: GearboxTypeDTO;

  isUpdate: boolean;
  gearboxTypes: Observable<GearboxTypeDTO[]>;

  constructor(private gearboxService: GearboxService) {
    this.isUpdate = false;
  }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.gearboxTypes = this.gearboxService.getGearboxs();
  }


  onGearboxTypeUpdate(gear: GearboxTypeDTO): void {
    console.log("xxxxxxxxxsssssssssssssssxxxxxxxxxxxxxxxxxx________" + gear.idGearboxType
      + " _____" + this.isUpdate);
    this.gearBoxType = gear;
    this.isUpdate = !this.isUpdate;
    console.log(this.isUpdate);
  }



}
