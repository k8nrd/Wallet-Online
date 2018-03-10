import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TransactionAddComponent } from './transaction-add.component';

const patches = [{path:'add', component: TransactionAddComponent}];
 @NgModule ({
     imports: [RouterModule.forRoot(patches)],
     exports: [RouterModule]
 
 })
export class AddRouter {}