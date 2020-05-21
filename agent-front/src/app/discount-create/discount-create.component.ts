import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { DiscountService } from '../services/discount.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-discount-create',
  templateUrl: './discount-create.component.html',
  styleUrls: ['./discount-create.component.css']
})
export class DiscountCreateComponent implements OnInit {
  discountForm: FormGroup;
  discountData: any;
  errorMessage: any;
  discountFormFailed = false;
  submitted = false;
  


  constructor(private formBuilder: FormBuilder,
              private discountService: DiscountService,
              private router: Router) {
   }

  ngOnInit() {
    this.discountForm = this.formBuilder.group({
      dani: [null],
      popust: [null]
    });
  }

  get f() { return this.discountForm.controls; }

  onSubmit() {
    this.submitted = true;
    this.discountData = this.discountForm.getRawValue()

    this.discountService.createNewDiscount(this.discountData).subscribe(
      data => {        
        //console.log("poslati podaci za popust");
        this.navigate();
      },
      error => {
        this.errorMessage = error.error.message;
        this.discountFormFailed = true;

        console.log("Error: " +  this.errorMessage);
      }
    );
  }

  navigate() {
    this.router.navigate(['/']);
  }

  onBack() {
    this.router.navigate(['/']);
  }
}
