import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CarBrandDTO} from '../admin/car-brand-list/CarBrandDTO';


@Injectable({
  providedIn: 'root'
})

export class CarBrandService {


  private carBrandUrl = 'http://localhost:8080/api/carbrand';

  constructor(private http: HttpClient) { }


  public getCarBrand(id): Observable<any> {
    // console.log('front poslao back stuffffffffffffffffffffff ' + this.carBrandUrl+ '/' +id);
    return this.http.get(this.carBrandUrl + '/' + id);
  }

  public getCarBrands(): Observable<any> {
    return this.http.get(this.carBrandUrl);
  }
  updateCarBrand(updateGearBoxType: any): Observable<any> {
    console.log("gears on servis is: " + updateGearBoxType.idGearboxType + " " + updateGearBoxType.name);
    // const roleName = new HttpParams().set('updateGearBoxType', updateGearBoxType.roleName);
    return this.http.put(this.carBrandUrl + '/' + updateGearBoxType.idGearboxType, updateGearBoxType);
  }

  deleteCarBrand(carBrand: CarBrandDTO) : Observable<any> {

    return this.http.delete(this.carBrandUrl + '/' + carBrand.idCarBrand);
  }

  addCarBrand(name: CarBrandDTO): Observable<any> {
    return this.http.post(this.carBrandUrl, name);
  }





}