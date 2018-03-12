import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TransactionAddComponent } from './transaction-add.component';
import { MainGuard } from '../../../main-guard';

const patches = [{path:'add', component: TransactionAddComponent, canActivate: [MainGuard]}];
 @NgModule ({
     imports: [RouterModule.forRoot(patches)],
     exports: [RouterModule]
 
 })
export class AddRouter {}