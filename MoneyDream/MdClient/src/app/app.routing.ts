import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { RequestComponent } from './request/request.component';
import {HeaderComponent} from './header/header.component';
import { SendMoneyComponent } from './send-money/send-money.component';
import { SearchComponent } from './search/search.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { BorrowMoneyComponent } from './borrow-money/borrow-money.component';


const appRoutes: Routes = [
   
    { path: 'login', component: LoginComponent },
    { path: 'requestMoney', component: RequestComponent },
    { path: 'sendMoney', component: SendMoneyComponent },
    { path: 'search', component: SearchComponent },
    { path: 'header', component: HeaderComponent },
    { path: 'dashboard', component: DashboardComponent},
    { path: 'borrowMoney', component: BorrowMoneyComponent },
    {path: '', component: LoginComponent, pathMatch: 'full'},
    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];


export const routing = RouterModule.forRoot(appRoutes);