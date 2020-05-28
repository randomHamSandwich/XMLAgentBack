import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { GearboxTypeDTO } from '../admin/gearbox-list/GearboxTypeDTO';


@Injectable({
  providedIn: 'root'
})

export class GearboxService {


  private GearboxUrl = 'http://localhost:8080/api/gearbox';

  constructor(private http: HttpClient) { }


  public getGearbox(id): Observable<any> {
    // console.log('front poslao back stuffffffffffffffffffffff ' + this.GearboxUrl+ '/' +id);
    return this.http.get(this.GearboxUrl + '/' + id);
  }

  public getGearboxs(): Observable<any> {
    return this.http.get(this.GearboxUrl);
  }
  updateGearboxType(updateGearBoxType: any): Observable<any> {
    console.log("gears on servis is: " + updateGearBoxType.idGearboxType + " " + updateGearBoxType.name);
    // const roleName = new HttpParams().set('updateGearBoxType', updateGearBoxType.roleName);
    return this.http.put(this.GearboxUrl + '/' + updateGearBoxType.idGearboxType, updateGearBoxType);
  }

  addGearboxType(name: GearboxTypeDTO): Observable<any> {
    return this.http.post(this.GearboxUrl, name);
  }

  // TODO
  //   public updateGeatbox(id: number, value: RoleDTO): Observable<any> {
  //     return this.http.put(this.GearboxUrl + '/' + id, value)
  //   }


}