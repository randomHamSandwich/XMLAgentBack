import { Component, OnInit } from '@angular/core';
import { PricelistDTO } from './PricelistDTO';
import { PricelistService } from 'src/app/services/pricelist.service';
import { DiscountService } from 'src/app/services/discount.service';
import { TokenStorageService } from 'src/app/auth/token-storage.service';

@Component({
  selector: 'app-pricelist-create',
  templateUrl: './pricelist-create.component.html',
  styleUrls: ['./pricelist-create.component.css']
})
export class PricelistCreateComponent implements OnInit {

  form: any = {};
  newPricelist = new PricelistDTO;
  discounts: any;

  isBack = false;
  submitted = false;
  isCreated = false;
  isFailed = false;
  errorMessage: string;
  errorMessageDiscounts: string;

  userId: string;

  constructor(private pricelistService: PricelistService,
              private discountService: DiscountService,
              private tokenService: TokenStorageService) { }

  ngOnInit() {
    this.userId = this.tokenService.getIdKorisnik();
    this.getDiscounts();
  }

  getDiscounts() {
    this.discountService.getAllDiscounts().subscribe(
      data => {
        this.discounts = data;
      },
      error => {
        this.errorMessageDiscounts = error.message;
        console.log("Error, get discounts: " + this.errorMessageDiscounts);
        
      }
    );
}

  onSubmit() {
    console.log("submitted");
    this.submitted = true;

    this.newPricelist = new PricelistDTO();
    this.newPricelist.priceForOneDay = this.form.priceForOneDay;
    this.newPricelist.priceForKM = this.form.priceForKM;
    this.newPricelist.discountId = this.form.discount;
    this.newPricelist.userId = +this.userId;
    
    this.pricelistService.createNewPricelist(this.newPricelist).subscribe(
      data => {
        console.log("created");
        this.isCreated = true;
        this.onBack();
      },
      error => {
        this.isFailed = true;
        console.log("ERROR, creating new pricelist: " + error.message);
      }
    );

    // window.location.reload();
  }

  onBack(): void {
    window.location.reload();
  }

}
