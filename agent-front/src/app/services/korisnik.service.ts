import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RoleDTO } from '../admin/change-authoriy/RoleDTO';





@Injectable({
  providedIn: 'root'
})

export class KorisnikService {


  private korisnikUrl = 'http://localhost:8080/api/user';

  
  changeRole( idUser : string, info: any): Observable<any>  {
    console.log("xxxxxxxxxxx stigno do servisa:_" + idUser);
    
    const roleName = new HttpParams().set('roleName', info.roleName);
    return this.http.put(this.korisnikUrl + '/'+idUser, roleName );

  }

  constructor(private http: HttpClient) { }

  public getKorisnik(id): Observable<any> {
    // console.log('front poslao back stuffffffffffffffffffffff ' + this.korisnikUrl+ '/' +id);
    return this.http.get(this.korisnikUrl + '/' + id);
  }

  public getAllKorisnik(): Observable<any> {
    return this.http.get(this.korisnikUrl );
  }

  public updateKorisnik(id: number, value: RoleDTO): Observable<any> {
    return this.http.put(this.korisnikUrl + '/' + id, value)
  }
 

}