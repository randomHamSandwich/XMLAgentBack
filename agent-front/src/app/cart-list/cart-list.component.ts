import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartItemDTO } from './CartItemDTO';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-cart-list',
  templateUrl: './cart-list.component.html',
  styleUrls: ['./cart-list.component.css']
})
export class CartListComponent implements OnInit {

  cartItems: CartItemDTO[] = [];
  cartItemSessions: CartItemDTO[] = [];
 

  constructor(private router: Router) { }

  ngOnInit() {

    this.populateData();
    this.retrieveSessionData();

  }

  populateData() {

    this.cartItemSessions.push(new CartItemDTO(1, "Toyota", "Corolla","10-12-2020","15-12-2020", 15, 5));
    this.cartItemSessions.push(new CartItemDTO(2, "Mitsubishi", "Pajero","08-12-2020","20-12-2020", 14, 3));
    this.cartItemSessions.push(new CartItemDTO(3, "Honda", "Accord","13-12-2020","15-12-2020", 12, 0));
    this.cartItemSessions.push(new CartItemDTO(4, "Suzuki", "Samurai","20-11-2020","28-11-2020", 14, 10));
    this.cartItemSessions.push(new CartItemDTO(5, "Suzuki", "Vitara","18-12-2020","26-12-2020", 15, 8));
    this.cartItemSessions.push(new CartItemDTO(6, "Mitsubishi", "Evo","25-10-2020","05-11-2020", 17, 12));
   
    sessionStorage.setItem("cart", JSON.stringify(this.cartItemSessions));
    
  }

  retrieveSessionData() {

    this.cartItems = JSON.parse(sessionStorage.getItem("cart"));

  }

  onBack() {
    this.router.navigate(['/']);
  }

}
