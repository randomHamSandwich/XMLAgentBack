import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { CarListComponent } from './car-list/car-list.component';
import { AdminComponent } from './admin/admin.component'; 
import { ChangeAuthoriyComponent} from './admin/change-authoriy/change-authoriy.component';
import { GearboxListComponent  } from './admin/gearbox-list/gearbox-list.component';
import { FuelTypeListComponent } from './admin/fuel-type-list/fuel-type-list.component';
import { CarClassListComponent } from './admin/car-class-list/car-class-list.component';
import {CarBrandListComponent} from './admin/car-brand-list/car-brand-list.component';
import { CarModelListComponent} from './admin/car-model-list/car-model-list.component'; 
import { DiscountListComponent } from './ad/discount-list/discount-list.component';

const routes: Routes = [
    {
        path: 'home',
        component: HomeComponent
    },
    {
        path: 'carList',
        component: CarListComponent
    },
    {
        path: 'users',
        component: ChangeAuthoriyComponent
    },
    {
        path: 'admin',
        component: AdminComponent
    },

    {
        path: 'gearbox',
        component: GearboxListComponent
    },
    {
        path: 'fueltype',
        component: FuelTypeListComponent
    },

    {
        path: 'carclass',
        component: CarClassListComponent
    },
    {
        path: 'carbrand',
        component: CarBrandListComponent

    },
    {
        path: 'carmodel',
        component: CarModelListComponent

    },
    {
        path: 'discounts',
        component: DiscountListComponent

    },

     


    {
        path: 'auth/login',
        component: LoginComponent
    },
    {
        path: 'signup',
        component: RegisterComponent
    },
    {
        path: '',
        redirectTo: 'home',
        pathMatch: 'full'
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
