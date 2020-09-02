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

  // Properties
  currentCartItem: CartItemDTO;
  cartItems: CartItemDTO[] = [];
  uniqueUsers: UniqueUserDTO[] = [];

  errorMessage: any;
  isDeleted = false;
  // Constructor
  constructor(
    private adService: AdService,
    private pricelistService: PricelistService,
    private cartStorageService: CartStorageService,
    private router: Router) { }

  // Initialization
  ngOnInit() {
    this.populateData();
  }

  populateData() {
    let ids = this.cartStorageService.getCartAdIds();

    ids.forEach( id => {
        this.adService.getAdById(parseInt(id)).subscribe(
        (data: AdResponse) => {
          this.pricelistService.getPricelistById(data.pricelist).subscribe(
            (pricelistData: PricelistResponse) => {
              this.storeCartItemData(data, pricelistData);
            },
            error => { console.log("Error: " + error.message); },
            );
          },
        error => { console.log("Error: " + error.message); },
        )
    });    
  }

  storeCartItemData(data: AdResponse, pricelistData: PricelistResponse){
    this.currentCartItem = new CartItemDTO(
      data.idAd,
      data.carBrand,
      data.carModel,
      data.startDate.toString(),
      data.endDate.toString(),
      data.priceForOneDay,
      pricelistData.discount,
      data.user);

    console.log("Attempted adding AdDTO with ID: " + this.currentCartItem.id + ". Car: " + this.currentCartItem.carBrand);
    console.log("Discount: " + this.currentCartItem.discount);

    this.cartItems.push(this.currentCartItem);

    if (!this.uniqueUsers.find(x => x.uniqueUserId == this.currentCartItem.user))
    {
      // TODO: find and add user name to this DTO
      this.uniqueUsers.push(new UniqueUserDTO(this.currentCartItem.user, "Lol TheLolie"));
    }
  };

  onDelete(){
    //TODO Delete button
    // this.adService.deleteAd(idAd).subscribe(
    //   data => {
    //     this.isDeleted = true;
    //     window.location.reload();
    //   }
  };

  onSendRequest(){
    //TODO Send request button
  };

  onSendBundle(){
    //TODO Send bundle button
  };

  onBack() {
    this.router.navigate(['/']);
  }
}
