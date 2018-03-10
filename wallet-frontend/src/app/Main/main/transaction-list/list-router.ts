import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TransactionListComponent } from './transaction-list.component';

const patches = [{path:'list', component: TransactionListComponent}];
 @NgModule ({
     imports: [RouterModule.forRoot(patches)],
     exports: [RouterModule]
 
 })
export class ListRouter {}