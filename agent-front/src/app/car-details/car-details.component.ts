import { Component, OnInit, Input} from '@angular/core';
import { CarDTO } from '../car-create/CarDTO';
import { ActivatedRoute, Router } from '@angular/router';
import { CarService } from '../services/car.service';
import { HttpClient, HttpEventType, HttpResponse } from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';
import { UploadFileService } from '../services/upload-file.service';
import { Observable } from 'rxjs';
import { FileDTO } from '../car-create/FileDTO';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-car-details',
  templateUrl: './car-details.component.html',
  styleUrls: ['./car-details.component.css']
})
export class CarDetailsComponent implements OnInit {

  car: CarDTO = new CarDTO();
  idCar: string;
  errorMessage: any;
  selectedFiles: FileList;
  currentFile: File;
  progress = 0;
  message = '';
  fileinfos : any;
  file: FileDTO = new FileDTO();
  image: any;
  data: any;
  

  constructor(private router: Router,
              private route: ActivatedRoute,
              private carService: CarService,
              private uploadService: UploadFileService,
              private http: HttpClient,
              private sanitizer: DomSanitizer) {}
  

  ngOnInit() {
    this.route.paramMap.subscribe(params => { this.idCar = params.get("idCar"); })
    this.getCarById();
    // this.image = btoa(this.car.photo);
    let objectURL = 'data:image/png;base64,'+this.car.photo;
    this.image = this.sanitizer.bypassSecurityTrustUrl(objectURL);
  }

  selectFile(event) {
    this.selectedFiles = event.target.files;
  }

  upload() {
    this.progress = 0;

    this.currentFile = this.selectedFiles.item(0);
    this.uploadService.upload(this.currentFile, this.idCar).subscribe(
      event => {
        if (event.type === HttpEventType.UploadProgress) {
          this.progress = Math.round(100 * event.loaded / event.total);
        } else if (event instanceof HttpResponse) {
          this.message = event.body.message;
        }
      },
      err => {
        this.progress = 0;
        this.message = 'Could not upload the file!';
        this.currentFile = undefined;
      });

    this.selectedFiles = undefined;
  }

  photoGud() {
    console.log("photo gud?");
    console.log(this.car.photo);
    // this.uploadService.getFile(this.idCar).subscribe(
    //   data => {
    //     this.file = data;
    //   },
    //   error => {
    //     {
    //       console.log("ERROR getFile: " + error.errorMessage);
    //     }
    //   }
    // )

    // const reader = new FileReader();
    // reader.onload = (e) => this.image = e.target.result;
    // reader.readAsDataURL(new Blob([this.car.photo]));
  }

  getCarById() {
    this.carService.getCarById(this.idCar).subscribe(
      data => {
        this.car = data;
      },
      error => {
        {
          console.log("ERROR getCarById: " + error.errorMessage);
          
        }
      }
    )
  }
  onBack() {
    this.router.navigate(['/carList']);
  }

  slides = [
    {img: this.image},
    {img: "http://placehold.it/350x150/111111"},
    {img: "http://placehold.it/350x150/333333"},
    {img: "http://placehold.it/350x150/666666"}
  ];
  slideConfig = {"slidesToShow": 4, "slidesToScroll": 4};

  addSlide() {
    this.slides.push({img: "http://placehold.it/350x150/777777"})
  }
  
  removeSlide() {
    this.slides.length = this.slides.length - 1;
  }
  
  slickInit(e) {
    console.log('slick initialized');
  }
  
  breakpoint(e) {
    console.log('breakpoint');
  }
  
  afterChange(e) {
    console.log('afterChange');
  }
  
  beforeChange(e) {
    console.log('beforeChange');
  }
}
