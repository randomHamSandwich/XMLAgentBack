import { Component, OnInit } from '@angular/core';
import { DiscountService } from '../services/discount.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-discount-list',
  templateUrl: './discount-list.component.html',
  styleUrls: ['./discount-list.component.css']
})
export class DiscountListComponent implements OnInit {
  discounts: any;
  errorMessage: any;

  constructor(private discountService: DiscountService,
              private router: Router) { }

  ngOnInit() {
    this.findAllDiscounts();
  }

  findAllDiscounts() {
    this.discountService.getDiscountsList().subscribe(
      data => {
        this.discounts = data;
      },
      error => {
        this.errorMessage = error.error.message;

        console.log("Error: " +  this.errorMessage);
      }
    );

  }

  onBack() {
    this.router.navigate(['/']);
  }

}
