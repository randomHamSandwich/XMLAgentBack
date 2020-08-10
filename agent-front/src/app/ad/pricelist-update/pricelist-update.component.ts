import { Component, OnInit, Input } from '@angular/core';
import { PricelistDTO } from '../pricelist-create/PricelistDTO';
import { PricelistService } from 'src/app/services/pricelist.service';
import { DiscountService } from 'src/app/services/discount.service';

@Component({
  selector: 'app-pricelist-update',
  templateUrl: './pricelist-update.component.html',
  styleUrls: ['./pricelist-update.component.css']
})
export class PricelistUpdateComponent implements OnInit {
  form: any = {};
  updatePricelist = new PricelistDTO;
  pricelistData: any;

  isUpdated = false;
  isError = false;
  errorUpdateMessage: any;
  errorMessage: any;
  errorDiscountsMessage: any;

  submitted = false;

  discounts: any;

  @Input() pricelistId: number;

  constructor(private pricelistService: PricelistService,
              private discountService: DiscountService) { }

  ngOnInit() {
    this.getPricelistById();
    this.getDiscounts();
  }

  getPricelistById() {
    this.pricelistService.getPricelistById(this.pricelistId).subscribe(
      data => {
        this.pricelistData = data;
      },
      error => {
        this.errorMessage = error.errorMessage;
        console.log("Error: " + this.errorMessage);
      }
    );
  }

  getDiscounts() {
    this.discountService.getAllDiscounts().subscribe(
      data => {
        this.discounts = data;
      },
      error => {
        this.errorDiscountsMessage = error.errorMessage;
        console.log("Discounts: " + this.errorDiscountsMessage);
        
      }
    );
  }

  onSubmit() {
    this.submitted = true;

    this.updatePricelist = new PricelistDTO();
    this.updatePricelist.priceForOneDay = this.form.priceForOneDay;
    this.updatePricelist.priceForKM = this.form.priceForKM;
    this.updatePricelist.discountId = this.form.discount;
    
    this.pricelistService.updatePricelist(this.pricelistId, this.updatePricelist).subscribe(
      data => {
        this.isUpdated = true;

        this.reloadPage();
      },
      error => {
        this.errorUpdateMessage = error.errorMessage;
        console.log("error: " + this.errorUpdateMessage);
        
      }
    );
  }

  reloadPage() {
    window.location.reload();
  }

}
