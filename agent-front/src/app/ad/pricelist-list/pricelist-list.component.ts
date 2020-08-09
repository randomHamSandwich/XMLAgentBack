import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { PricelistDTO } from '../pricelist-create/PricelistDTO';
import { PricelistService } from 'src/app/services/pricelist.service';
import { Router } from '@angular/router';
import { DiscountService } from 'src/app/services/discount.service';
import { TokenStorageService } from 'src/app/auth/token-storage.service';

@Component({
  selector: 'app-pricelist-list',
  templateUrl: './pricelist-list.component.html',
  styleUrls: ['./pricelist-list.component.css']
})
export class PricelistListComponent implements OnInit {
  pricelist: PricelistDTO;
  pricelists: Observable<PricelistDTO[]>

  discounts: any;

  isAdd = false;
  userId: number;

  constructor(private pricelistService: PricelistService,
              private discountService: DiscountService,
              private tokenStorage: TokenStorageService) { }

  ngOnInit() {
    this.findAllPricelists();
    this.getDiscounts();

    this.userId = +this.tokenStorage.getIdKorisnik();
  }

  findAllPricelists() {
    this.pricelists = this.pricelistService.getAllPricelists();
  }

  onPricelistAdd(): void {
    this.isAdd = !this.isAdd;
  }

  getDiscounts() {
    this.discountService.getAllDiscounts().subscribe(
      data => {
        this.discounts = data;
      }
    );
  }

}
