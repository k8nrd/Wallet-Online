import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { StartPageComponent } from './StartPage/start-page/start-page.component';
import { RegisterPageComponent } from './StartPage/register-page/register-page.component';
import { NavbarComponent } from './Navbar/navbar/navbar.component';
import { MainComponent } from './Main/main/main.component';
import { NavMenuComponent } from './Main/main/nav-menu/nav-menu.component';
import { TransactionListComponent } from './Main/main/transaction-list/transaction-list.component';
import { TransactionAddComponent } from './Main/main/transaction-add/transaction-add.component';
import { ChartsComponent } from './Main/main/charts/charts.component';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { ListRouter } from './Main/main/transaction-list/list-router';
import { AddRouter } from './Main/main/transaction-add/add-router';
import { LoginRouter } from './StartPage/start-page/login-router';
import { RegisterRouter } from './StartPage/register-page/register-router';
import { AppService } from './Services/auth-service';
import { HttpClientModule } from '@angular/common/http';
import { CookieService } from 'ngx-cookie-service';
import { TransactionService } from './Services/transaction-service';


@NgModule({
  declarations: [
    AppComponent,
    StartPageComponent,
    RegisterPageComponent,
    NavbarComponent,
    MainComponent,
    NavMenuComponent,
    TransactionListComponent,
    TransactionAddComponent,
    ChartsComponent
  ],
  imports: [
    NgbModule.forRoot(),
    BrowserModule,
    RouterModule,
    FormsModule,
    AddRouter,
    ListRouter,
    LoginRouter,
    RegisterRouter,
    HttpClientModule
  ],
  providers: [AppService, CookieService, TransactionService],
  bootstrap: [AppComponent]
})
export class AppModule { }
