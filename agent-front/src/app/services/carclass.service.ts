import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CarClassDTO } from '../admin/car-class-list/CarClassDTO';


@Injectable({
  providedIn: 'root'
})

export class CarClassService {

  private carClassUrl = 'http://localhost:8080/api/carclass';

  constructor(private http: HttpClient) { }

  public getCarClass(id): Observable<any> {
    return this.http.get(this.carClassUrl + '/' + id);
  }

  public getCarClasses(): Observable<any> {
    return this.http.get(this.carClassUrl);
  }
  updateCarClass(updateGearBoxType: any): Observable<any> {
    console.log("gears on servis is: " + updateGearBoxType.idGearboxType + " " + updateGearBoxType.name);

    return this.http.put(this.carClassUrl + '/' + updateGearBoxType.idGearboxType, updateGearBoxType);
  }

  deleteCarClass(carClass: CarClassDTO): Observable<any> {

    return this.http.delete(this.carClassUrl + '/' + carClass.idCarClass);
  }

  addCarClass(name: CarClassDTO): Observable<any> {
    return this.http.post(this.carClassUrl, name);
  }


}  