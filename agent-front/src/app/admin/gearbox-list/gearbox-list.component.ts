import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { GearboxService } from 'src/app/services/gearbox.service';
import { GearboxType } from 'src/app/admin/gearbox-list/GearboxType'

@Component({
  selector: 'app-gearbox-list',
  templateUrl: './gearbox-list.component.html',
  styleUrls: ['./gearbox-list.component.css']
})
export class GearboxListComponent implements OnInit {

  gearboxTypes: Observable<GearboxType[]>;

  constructor(private gearboxService: GearboxService) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.gearboxTypes = this.gearboxService.getGearboxs();
  }

}
