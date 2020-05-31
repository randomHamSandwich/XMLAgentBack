import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CarDTO } from '../car-create/CarDTO';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  private baseUrl = 'http://localhost:8080/api';

  constructor(private http:HttpClient) {}

  createNewCar(data: CarDTO): Observable<any> {
    return this.http.post(this.baseUrl + '/car', data);
  }

  public updateCar() {

  }

  public getCarById() {

  }

  public getCarsList() {
    return this.http.get(this.baseUrl + '/car');
  }
}
