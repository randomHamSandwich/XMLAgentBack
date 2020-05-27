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

    GearboxComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
