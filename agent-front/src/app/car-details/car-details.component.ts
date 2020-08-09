import { Component, OnInit, Input} from '@angular/core';
import { CarDTO } from '../car-create/CarDTO';
import { ActivatedRoute, Router } from '@angular/router';
import { CarService } from '../services/car.service';

@Component({
  selector: 'app-car-details',
  templateUrl: './car-details.component.html',
  styleUrls: ['./car-details.component.css']
})
export class CarDetailsComponent implements OnInit {

  // car: Observable<any>;
  car: CarDTO = new CarDTO();
  idCar: string;
  errorMessage: any;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private carService: CarService) { 
  }

  ngOnInit() {
    this.route.paramMap.subscribe(params => { this.idCar = params.get("idCar"); })
    this.getCarById();
    console.log(this.car);
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
    {img: "http://placehold.it/350x150/000000"},
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
