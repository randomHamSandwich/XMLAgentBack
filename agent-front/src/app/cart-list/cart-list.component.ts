import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartItemDTO } from './CartItemDTO';
import { CartStorageService } from '../services/cart-storage.service';
import { AdService } from '../services/ad.service';
import { UniqueUserDTO } from './UniqueUserDTO';
import { PricelistService } from '../services/pricelist.service';
import { AdResponse } from '../services/responses/AdResponse';
import { PricelistResponse } from '../services/responses/PricelistResponse';
import { CartItemRequestDTO } from './CartItemRequestDTO';
import { UUID } from 'angular2-uuid';
import { ReservationService } from '../services/reservation.service';

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

  // Constructor
  constructor(
    private adService: AdService,
    private pricelistService: PricelistService,
    private cartStorageService: CartStorageService,
    private router: Router,
    private reservationService : ReservationService) { }

  // Initialization
  ngOnInit() {
    this.populateData();
  }

  populateData() {
    let cartRequests = this.cartStorageService.getCartRequests();

    cartRequests.forEach( request => {
        this.adService.getAdById(request.adId).subscribe(
        (data: AdResponse) => {
          this.pricelistService.getPricelistById(data.pricelist).subscribe(
            (pricelistData: PricelistResponse) => {
              this.storeCartItemData(data, pricelistData, request);
            },
            error => { console.log("Error: " + error.message); },
            );
          },
        error => { console.log("Error: " + error.message); },
        )
    });    
  }

  storeCartItemData(adData: AdResponse, pricelistData: PricelistResponse, requestData: CartItemRequestDTO){
    this.currentCartItem = new CartItemDTO(
      requestData.reqId,
      adData.idAd,
      adData.carBrand,
      adData.carModel,
      requestData.startDate.toString(),
      requestData.endDate.toString(),
      adData.priceForOneDay,
      pricelistData.discount,
      adData.user);

    console.log("Attempted adding AdDTO with ID: " + this.currentCartItem.id + ". Car: " + this.currentCartItem.carBrand);
    console.log("Discount: " + this.currentCartItem.discount);

    this.cartItems.push(this.currentCartItem);

    if (!this.uniqueUsers.find(x => x.uniqueUserId == this.currentCartItem.user))
    {
      // TODO: find and add user name to this DTO (korisnik.service.ts)
      this.uniqueUsers.push(new UniqueUserDTO(this.currentCartItem.user, "Lol TheLolie"));
    }
  };

  onDelete(id: UUID){
    let index = this.cartItems.findIndex( c => c.id === id );
    this.cartItems.splice(index, 1);
    this.cartStorageService.deleteRequest(id);
  };

  onSendRequest(requestId: UUID){
    var targetCartItem = this.cartItems.find( item => item.id === requestId );

    this.reservationService.crate(targetCartItem).subscribe(
      data => {
        console.log(data);

      },
      error => {
        console.log(error);
      }
    );
    //TODO implement reservation service
    //this.reservationService.addReservation(targetCartItem);
  };

  onSendBundle(userId: number){
    //TODO Send bundle button
    let targetReservations = Array<CartItemDTO>();
    this.cartItems.forEach( cartItem => {
      if (cartItem.user === userId) {
        targetReservations.push(cartItem)
      }
    });
    //this.reservationService.addReservation(targetReservations);
  };

  onBack() {
    this.router.navigate(['/']);
  }

  emptyCart(){
    this.cartStorageService.emptyCart();
    this.cartItems.splice(0, this.cartItems.length);
  }
}
