import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TransactionListComponent } from './transaction-list.component';
import { MainGuard } from '../../../main-guard';

const patches = [{path:'list', component: TransactionListComponent, canActivate: [MainGuard]}];
 @NgModule ({
     imports: [RouterModule.forRoot(patches)],
     exports: [RouterModule]
 
 })
export class ListRouter {}