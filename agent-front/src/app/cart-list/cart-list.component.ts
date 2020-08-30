import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartItemDTO } from './CartItemDTO';
import { CartStorageService } from '../services/cart-storage.service';
import { AdService } from '../services/ad.service';
import { UniqueUserDTO } from './UniqueUserDTO';
import { PricelistService } from '../services/pricelist.service';
import { AdResponse } from '../services/responses/adResponse';
import { PricelistResponse } from '../services/responses/PricelistResponse';

@Component({
  selector: 'app-cart-list',
  templateUrl: './cart-list.component.html',
  styleUrls: ['./cart-list.component.css']
})
export class CartListComponent implements OnInit {

  currentCartItem: CartItemDTO;

  cartItems: CartItemDTO[] = [];

  uniqueUsers: UniqueUserDTO[] = [];

  constructor(
    private adService: AdService,
    private pricelistService: PricelistService,
    private cartStorageService: CartStorageService,
    private router: Router) { }

  ngOnInit() {
    this.populateData();
  }

  populateData() {
    let ids = this.cartStorageService.getCartAdIds();

    ids.forEach( id => {
      this.adService.getAdById(parseInt(id)).subscribe(
        (data: AdResponse) => {
          this.pricelistService.getPricelistById(data.pricelist).subscribe(
            (pricelistData: PricelistResponse) =>
            {
              this.currentCartItem = new CartItemDTO(
                data.idAd,
                data.carBrand,
                data.carModel,
                data.startDate.toString(),
                data.endDate.toString(),
                data.priceForOneDay,
                pricelistData.discount);
      
              console.log("Attempted adding AdDTO with ID: " + this.currentCartItem.id + ". Car: " + this.currentCartItem.carBrand);
              console.log("Discount: " + this.currentCartItem.discount);
      
              this.cartItems.push(this.currentCartItem);
            },
            error =>
            {
              console.log("Error: " + error.errorMessage);
            }
          );
        },

        error => {
          {
            console.log("ERROR: " + error.errorMessage);            
          }
        }
      )
    });    
  }

  onBack() {
    this.router.navigate(['/']);
  }
}
