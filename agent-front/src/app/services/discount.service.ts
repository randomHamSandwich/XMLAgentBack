import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DiscountService {

  private baseUrl = 'http://localhost:8080';

  constructor(private http:HttpClient) {}

  createNewDiscount(discount) {
    return this.http.post(this.baseUrl + '/create/', discount);
  }

  updateDiscount() {

  }

  getDiscountById() {

  }

  getDiscountsList() {
    return this.http.get(this.baseUrl + '/popusti');
  }
}
