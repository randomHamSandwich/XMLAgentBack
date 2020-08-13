import { Component, OnInit } from '@angular/core';
import { AdDTO } from '../ad-create/AdDTO';
import { AdService } from 'src/app/services/ad.service';
import { CarService } from 'src/app/services/car.service';
import { PricelistService } from 'src/app/services/pricelist.service';
import { Router, ActivatedRoute } from '@angular/router';
import { TokenStorageService } from 'src/app/auth/token-storage.service';

@Component({
  selector: 'app-ad-update',
  templateUrl: './ad-update.component.html',
  styleUrls: ['./ad-update.component.css']
})
export class AdUpdateComponent implements OnInit {
  form: any = {};
  updatedAd = new AdDTO;
  pricelists: any;

  errorMessage: any;
  submitted = false;

  ads: any;
  adId: number;
  adData:any;

  userId: number;

  constructor(private adService: AdService,
              private pricelistService: PricelistService,
              private tokenService: TokenStorageService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.adId = this.route.snapshot.params['idAd'];
    this.userId = +this.tokenService.getIdKorisnik();
    this.getAdData();
    this.getPricelists();
  }

  getAdData() {
    this.adService.getAdById(this.adId).subscribe(
      data => {
        this.adData = data;
      },
      error => {
        console.log("Error: " + error.errorMessage);
        
      }
    );
  }

  getPricelists() {
    this.pricelistService.getAllPricelists().subscribe(
      data => {
        console.log("getting pricelists");
        
        this.pricelists = data;
      },
      error => {
        this.errorMessage = error.error.errorMessage;
        console.log("Error: " + this.errorMessage);
      }
    );
  }

  onSubmit() {
    this.submitted = true;

    this.updatedAd = new AdDTO();
    this.updatedAd.startDate = this.form.startDate;
    this.updatedAd.endDate = this.form.endDate;
    this.updatedAd.pricelist = this.form.pricelist;
    
    this.adService.updateAd(this.adId, this.updatedAd).subscribe(
      data => {
        console.log("poslato");
      },
      error => {
        console.log("error: " + error.errorMessage);
        
      }
    );
    
  }

  goBack() {
    this.router.navigate(['/ads-dashboard']);
  }

}
