import { Component, OnInit, Input } from '@angular/core';
import { DiscountDTO } from '../discount-create/DiscountDTO';
import { DiscountService } from 'src/app/services/discount.service';

@Component({
  selector: 'app-discount-update',
  templateUrl: './discount-update.component.html',
  styleUrls: ['./discount-update.component.css']
})
export class DiscountUpdateComponent implements OnInit {
  form: any ={};
  updateDiscount = new DiscountDTO;
  discountData: any;

  isUpdated = false;
  isError = false;
  isUpdateError = false;
  errorUpdateMessage: any;
  errorMessage: any;
  
  submitted = false;

  @Input() idDiscount: number;

  constructor(private discountService: DiscountService) { }

  ngOnInit() {
    console.log("discount id: " + this.idDiscount);
    this.getDiscountData();
    
  }

  getDiscountData() {
    this.discountService.getDiscountById(this.idDiscount).subscribe(
      data => {
        this.discountData = data;
      },
      error => {
        this.isError = true;
        this.errorMessage = error.message;
        console.log("error: " + this.errorMessage);
        
      }
    );
  }

  onSubmit() {
    this.submitted = true;

    this.updateDiscount.moreThanXDays = this.form.moreThanXDays;
    this.updateDiscount.discount = this.form.discount;

    console.log("more than x days: " +  this.updateDiscount.moreThanXDays);
    console.log("discount: " + this.updateDiscount.discount);
    
    this.discountService.updateDiscount(this.idDiscount, this.updateDiscount).subscribe(
      data => {
        this.isUpdated = true;

        this.onReload();
      },
      error => {
        this.isUpdateError = true;
        this.errorUpdateMessage = error.message;
        console.log("Error: " + this.errorUpdateMessage);
      }
    );
  }

  onReload() {
    window.location.reload();
  }

}
