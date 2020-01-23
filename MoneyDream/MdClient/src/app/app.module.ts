import {BrowserModule} from '@angular/platform-browser'
import { NgModule,forwardRef } from '@angular/core';
import { FormsModule, FormControl } from '@angular/forms';

import { HttpClientModule } from '@angular/common/http';

import { routing } from './app.routing';
import { AppComponent } from './app.component';
import {HeaderComponent} from './header/header.component'
import { RequestComponent } from './request/request.component';
import { SendMoneyComponent } from './send-money/send-money.component';
import { SearchComponent } from './search/search.component';
import { LoginComponent } from './login/login.component';
import { DropdownDirective } from './shared/dropdown.directive';
import {ReactiveFormsModule} from "@angular/forms"


import {AuthenticationService} from '../service/authentication.service';
import {RegistrationService} from  '../service/register.service';
import {TransactionBorrowerSerivce} from  '../service/transactionborrower.service';
import {AddMoneyToWallet} from '../service/addMoneyToWallet.service';

import {GetWalletService} from  '../service/getWallet.service';
import { DashboardComponent } from './dashboard/dashboard.component';
import { QuickLinksComponent } from './quick-links/quick-links.component';
import { AnalyticsComponent } from './analytics/analytics.component';
import { NotificationComponent } from './notification/notification.component';
import { BorrowMoneyComponent } from './borrow-money/borrow-money.component';
import { WalletComponent } from './wallet/wallet.component';
import { UserService } from '../service/search.service';



@NgModule({
  declarations: [
    AppComponent,
    RequestComponent,
    SendMoneyComponent,
    SearchComponent,
    LoginComponent,
    DropdownDirective,
    DashboardComponent,
    QuickLinksComponent,
    AnalyticsComponent,
    HeaderComponent,
    NotificationComponent,
    BorrowMoneyComponent,
    WalletComponent
 
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    routing,
   

  ],
  providers: [AuthenticationService,RegistrationService,TransactionBorrowerSerivce,GetWalletService,UserService,AddMoneyToWallet],
  bootstrap: [AppComponent]
})
export class AppModule { }
