import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AdService } from 'src/app/services/ad.service';
import { CarService } from 'src/app/services/car.service';
import { AdDTO } from '../ad-create/AdDTO';
import { CartStorageService } from 'src/app/services/cart-storage.service';
import { UUID } from 'angular2-uuid'
import { CartItemRequestDTO } from 'src/app/cart-list/CartItemRequestDTO';

@Component({
  selector: 'app-ad-details',
  templateUrl: './ad-details.component.html',
  styleUrls: ['./ad-details.component.css']
})
export class AdDetailsComponent implements OnInit {
  adId: number;
  ad: AdDTO = new AdDTO();

  form: any = {};

  cars: any;

  errorMessage: any;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private adService: AdService,
              private carService: CarService,
              private cartStorageService : CartStorageService) { }

  ngOnInit() {
    this.adId = this.route.snapshot.params['idAd'];
    this.getAdById();
    this.getAllCars();
  }

  getAdById() {
    this.adService.getAdById(this.adId).subscribe(
      data => {
        this.ad = data;
      },
      error => {
        {
          console.log("ERROR je: " + error.errorMessage);
          
        }
      }
    )
  }

  getAllCars() {
    this.carService.getCarsList().subscribe(
      data => {
        this.cars = data;        
      },
      error => {
        this.errorMessage = error.error.message;

        console.log("Error: " + this.errorMessage);
      }
    );
  }

  
  onAddToCart() {
    let reqId = UUID.UUID();
    let startTime = this.form.startDateTime;
    let endTime = this.form.endDateTime;
    console.log(" Ad Id: " + this.ad.idAd);
    
    // TODO: Create new cart item request object, and feed it to session storage
    let cartItemRequestDTO = new CartItemRequestDTO(reqId, this.adId, startTime, endTime);
    this.cartStorageService.addCartRequest(cartItemRequestDTO);
    
    this.router.navigate(["/cart-list"]);
  }

  onBack() {
    this.router.navigate(['/']);
  }

}
