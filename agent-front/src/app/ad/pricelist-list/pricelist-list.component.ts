import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { PricelistDTO } from '../pricelist-create/PricelistDTO';
import { PricelistService } from 'src/app/services/pricelist.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pricelist-list',
  templateUrl: './pricelist-list.component.html',
  styleUrls: ['./pricelist-list.component.css']
})
export class PricelistListComponent implements OnInit {
  pricelist: PricelistDTO;
  pricelists: Observable<PricelistDTO[]>

  isAdd = false;

  constructor(private pricelistService: PricelistService) { }

  ngOnInit() {
    this.findAllPricelists()
  }

  findAllPricelists() {
    this.pricelists = this.pricelistService.getAllPricelists();
  }

  onPricelistAdd(): void {
    this.isAdd = !this.isAdd;
    //console.log("isAdd: " + this.isAdd);
  }

}
