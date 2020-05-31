import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';


import { httpInterceptorProviders } from './auth/auth-interceptor';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { KrajnjiKorisnikComponent } from './krajnji-korisnik/krajnji-korisnik.component';
import { AdminComponent } from './admin/admin.component';
import { AgentComponent } from './agent/agent.component';
import { CarCreateComponent } from './car-create/car-create.component';
import { CarListComponent } from './car-list/car-list.component';

import { ChangeAuthoriyComponent } from './admin/change-authoriy/change-authoriy.component';
import { CarBrandListComponent } from './admin/car-brand-list/car-brand-list.component';
import { CarClassListComponent } from './admin/car-class-list/car-class-list.component';
import { CarModelListComponent } from './admin/car-model-list/car-model-list.component';
import { FuelTypeListComponent } from './admin/fuel-type-list/fuel-type-list.component';
import { GearboxListComponent } from './admin/gearbox-list/gearbox-list.component';
import { GearboxComponent } from './admin/gearbox-list/gearbox/gearbox.component';
import { GearboxAddComponent } from './admin/gearbox-list/gearbox-add/gearbox-add.component';
import { FuelTypeUpdateComponent } from './admin/fuel-type-list/fuel-type-update/fuel-type-update.component';
import { FuelTypeAddComponent } from './admin/fuel-type-list/fuel-type-add/fuel-type-add.component';
import { CarClassAddComponent } from './admin/car-class-list/car-class-add/car-class-add.component';
import { CarClassUpdateComponent } from './admin/car-class-list/car-class-update/car-class-update.component';
import { CarBrandUpdateComponent } from './admin/car-brand-list/car-brand-update/car-brand-update.component';
import { CarBrandAddComponent } from './admin/car-brand-list/car-brand-add/car-brand-add.component';
import { CarModelAddComponent } from './admin/car-model-list/car-model-add/car-model-add.component';
import { CarModelUpdateComponent } from './admin/car-model-list/car-model-update/car-model-update.component';
import { DiscountCreateComponent } from './ad/discount-create/discount-create.component';
import { DiscountListComponent } from './ad/discount-list/discount-list.component';
import { AdCreateComponent } from './ad/ad-create/ad-create.component';
import { AdListComponent } from './ad/ad-list/ad-list.component';
import { AdComponent } from './ad/ad.component';
import { PricelistListComponent } from './ad/pricelist-list/pricelist-list.component';
import { PricelistCreateComponent } from './ad/pricelist-create/pricelist-create.component';
import { AdDetailsComponent } from './ad/ad-details/ad-details.component';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    RegisterComponent,
    KrajnjiKorisnikComponent,
    AdminComponent,
    AgentComponent,
    CarCreateComponent,
    CarListComponent,
    ChangeAuthoriyComponent,
    CarBrandListComponent,
    CarClassListComponent,
    CarModelListComponent,
    FuelTypeListComponent,
    GearboxListComponent,
    GearboxComponent,
    GearboxAddComponent,
    FuelTypeUpdateComponent,
    FuelTypeAddComponent,
    CarClassAddComponent,
    CarClassUpdateComponent,
    CarBrandUpdateComponent,
    CarBrandAddComponent,
    CarModelAddComponent,
    CarModelUpdateComponent,
    DiscountCreateComponent,
    DiscountListComponent,
    AdCreateComponent,
    AdListComponent,
    AdComponent,
    PricelistListComponent,
    PricelistCreateComponent,
    AdDetailsComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BsDatepickerModule.forRoot(),
    BrowserAnimationsModule
  ],
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
