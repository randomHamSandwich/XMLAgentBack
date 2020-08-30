import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpHeaders, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UploadFileService {

  private baseUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  upload(file: File, carId: string): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();
    console.log("uploadFileService: ")
    console.log(file);
    formData.append('file', file, carId);

    const req = new HttpRequest('POST', this.baseUrl+'/upload', formData, {
      reportProgress: true,
      responseType: 'json'
    });

    return this.http.request(req);
  }

  getFile(idCar: any): Observable<any> {
    return this.http.get(this.baseUrl+'/files/1');
  }

  getFiles(): Observable<any> {
    return this.http.get(this.baseUrl+'/files');
  }
}