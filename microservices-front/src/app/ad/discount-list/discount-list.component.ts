import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DiscountDTO } from '../discount-create/DiscountDTO';
import { Observable } from 'rxjs';
import { DiscountService } from 'src/app/services/discount.service';
import { TokenStorageService } from 'src/app/auth/token-storage.service';

@Component({
  selector: 'app-discount-list',
  templateUrl: './discount-list.component.html',
  styleUrls: ['./discount-list.component.css']
})
export class DiscountListComponent implements OnInit {
  discount: DiscountDTO;
  discounts: Observable<DiscountDTO[]>

  isAdd = false;
  userId: number;

  idDiscount: number;
  isUpdate = false;

  activeDiscounts: any;

  constructor(private discountService: DiscountService,
              private tokenService: TokenStorageService,
              private router: Router) { }

  ngOnInit() {
    this.userId = +this.tokenService.getIdKorisnik();
    //this.findAllDiscounts();
    this.findActiveDiscounts();
  }

  /*findAllDiscounts() {    
    //this.discounts = this.discountService.getAllDiscounts();
    this.discountService.getAllDiscounts().subscribe(
      data => {
        this.discounts = data;
      },
      error => {
        console.log("error: " + error.message);
        
      }
    );
  }*/

  findActiveDiscounts() {    
    //this.discounts = this.discountService.getAllDiscounts();
    this.discountService.getActiveDiscounts(this.userId).subscribe(
      data => {
        this.discounts = data;
      },
      error => {
        console.log("error: " + error.message);
        
      }
    );
  }

  onBack() {
    this.router.navigate(['/']);
  }

  onDiscountAdd(): void {
    this.isAdd = !this.isAdd;
    //console.log("isAdd: " + this.isAdd);
  }

  onDiscountUpdate(id): void {
    this.idDiscount = id;
    console.log("pricelistId: " + this.idDiscount);
    
    this.isUpdate = !this.isUpdate;
  }

}
