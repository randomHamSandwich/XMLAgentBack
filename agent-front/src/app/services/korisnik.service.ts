import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';




@Injectable({
  providedIn: 'root'
})

export class KorisnikService {

  private korisnikUrl = 'http://localhost:8080/api/kroisnik';

  constructor(private http: HttpClient) { }

  public getKorisnik(id): Observable<any> {
    // console.log('front poslao back stuffffffffffffffffffffff ' + this.korisnikUrl+ '/' +id);
    return this.http.get(this.korisnikUrl + '/' + id);
  }

  public getAllKorisnik(): Observable<any> {
    return this.http.get(this.korisnikUrl );
  }

  public updateKorisnik(id: number, value: any): Observable<any> {
    return this.http.put(this.korisnikUrl + '/' + id, value)
  }
 

}