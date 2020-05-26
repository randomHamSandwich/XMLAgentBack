import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { CarListComponent } from './car-list/car-list.component';
import { AdminComponent } from './admin/admin.component'; 
import { ChangeAuthoriyComponent} from './admin/change-authoriy/change-authoriy.component';
import { GearboxListComponent  } from './admin/gearbox-list/gearbox-list.component';

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
