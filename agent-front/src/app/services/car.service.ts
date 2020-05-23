import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  private baseUrl = 'http://localhost:8080';

  constructor(private http:HttpClient) {}

  createNewDiscount(car) {
    return this.http.post(this.baseUrl + '/create/', car);
  }

  updateCar() {

  }

  getCarById() {

  }

  getCarsList() {
    return this.http.get(this.baseUrl + '/vozila');
  }
}
