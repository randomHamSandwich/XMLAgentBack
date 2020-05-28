import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DiscountDTO } from '../discount-create/DiscountDTO';
import { Observable } from 'rxjs';
import { DiscountService } from 'src/app/services/discount.service';

@Component({
  selector: 'app-discount-list',
  templateUrl: './discount-list.component.html',
  styleUrls: ['./discount-list.component.css']
})
export class DiscountListComponent implements OnInit {
  discount: DiscountDTO;
  discounts: Observable<DiscountDTO[]>

  isAdd = false;

  constructor(private discountService: DiscountService,
              private router: Router) { }

  ngOnInit() {
    this.findAllDiscounts();
  }

  findAllDiscounts() {
    console.log("in find all discounts");
    
    this.discounts = this.discountService.getAllDiscounts();

  }

  onBack() {
    this.router.navigate(['/']);
  }

  onDiscountAdd(): void {
    this.isAdd = !this.isAdd;
    console.log("isAdd: " + this.isAdd);
  }

  pickDiscount(id: number) {
    console.log("choosen discount: " + id);
    
  }

}
