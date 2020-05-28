import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DiscountDTO } from './DiscountDTO';
import { DiscountService } from 'src/app/services/discount.service';

@Component({
  selector: 'app-discount-create',
  templateUrl: './discount-create.component.html',
  styleUrls: ['./discount-create.component.css']
})
export class DiscountCreateComponent implements OnInit {
  form: any = {};
  newDiscount = new DiscountDTO;

  constructor(private discountService: DiscountService,
              private router: Router) {

  }
  
  ngOnInit() {
    
  }

  onSubmit() {
    this.newDiscount = new DiscountDTO();
    this.newDiscount.moreThanXDays = this.form.moreThanXDays;
    this.newDiscount.discount = this.form.discount;

    this.discountService.createNewDiscount(this.newDiscount).subscribe(
      data => {
        console.log(data);
        this.newDiscount = data as DiscountDTO;
      },
      error =>  {
        console.log(error);
      }
    );
    window.location.reload();
  }

  navigate() {
    this.router.navigate(['/']);
  }

  onBack() {
    this.router.navigate(['/']);
  }
}
