import { Injectable } from '@angular/core';
import { CartItemRequestDTO } from '../cart-list/CartItemRequestDTO';

const SESSION_CART = 'sessionCart';

@Injectable({
    providedIn: 'root'
})

export class CartStorageService {
 
    constructor() {
    }

    public emptyCart() {
        window.sessionStorage.removeItem(SESSION_CART);
    }

    public addCartRequest(requestDTO: CartItemRequestDTO) {
        let currentCartRequests = this.getCartRequests();
        //TODO check if requestDTO already exists
        currentCartRequests.push(requestDTO);
        window.sessionStorage.removeItem(SESSION_CART);
        sessionStorage.setItem(SESSION_CART, JSON.stringify(currentCartRequests));
    }

    public getCartRequests(): CartItemRequestDTO[] {

        let requests = Array<CartItemRequestDTO>();

        if (sessionStorage.getItem(SESSION_CART)) {
            JSON.parse(sessionStorage.getItem(SESSION_CART)).forEach((request:CartItemRequestDTO) => {
                requests.push(request);
            });
        }

        return requests;
    }
}  