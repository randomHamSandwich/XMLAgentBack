import { Component, OnInit } from '@angular/core';
import { PricelistDTO } from './PricelistDTO';
import { PricelistService } from 'src/app/services/pricelist.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pricelist-create',
  templateUrl: './pricelist-create.component.html',
  styleUrls: ['./pricelist-create.component.css']
})
export class PricelistCreateComponent implements OnInit {

  form: any = {};
  newPricelist = new PricelistDTO;

  isBack = false;

  constructor(private pricelistService: PricelistService,
              private router: Router) { }

  ngOnInit() {
  }

  onSubmit() {
    this.newPricelist = new PricelistDTO();
    this.newPricelist.priceForOneDay = this.form.priceForOneDay;
    this.newPricelist.priceForKM = this.form.priceForKM;

    this.pricelistService.createNewPricelist(this.newPricelist).subscribe(
      data => {
        console.log(data);
        this.newPricelist = data as PricelistDTO;
      },
      error => {
        console.log(error);
        
      }
    );

    window.location.reload();
  }

  onBack(): void {
    window.location.reload();
  }

}
