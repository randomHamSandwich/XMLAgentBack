import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DiscountDTO } from './DiscountDTO';
import { DiscountService } from 'src/app/services/discount.service';
import { TokenStorageService } from 'src/app/auth/token-storage.service';

@Component({
  selector: 'app-discount-create',
  templateUrl: './discount-create.component.html',
  styleUrls: ['./discount-create.component.css']
})
export class DiscountCreateComponent implements OnInit {
  form: any = {};
  newDiscount = new DiscountDTO;
  userId: any;

  submitted = false;

  constructor(private discountService: DiscountService,
              private tokenService: TokenStorageService,
              private router: Router) {

  }
  
  ngOnInit() {
    this.userId = this.tokenService.getIdKorisnik();
  }

  onSubmit() {
    this.submitted = true;
    
    this.newDiscount = new DiscountDTO();
    this.newDiscount.moreThanXDays = this.form.moreThanXDays;
    this.newDiscount.discount = this.form.discount;
    this.newDiscount.userId = +this.userId; 

    this.discountService.createNewDiscount(this.newDiscount).subscribe(
      data => {
        console.log(data);
        this.newDiscount = data as DiscountDTO;
        //when discount is created THEN reload the page for new info
        this.onBack();
      },
      error =>  {
        console.log("error: " + error.message);
      }
    );
    //sometimes rolead habens before data is created so creat does not pass
    //it just reloads the window
    // window.location.reload();
  }

  navigate() {
    this.router.navigate(['/']);
  }

  onBack() {
    //this.router.navigate(['/']);
    window.location.reload();
  }
}
