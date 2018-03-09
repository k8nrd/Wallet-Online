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
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
