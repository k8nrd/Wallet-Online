import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const patches = [{path:'', redirectTo: '/login', pathMatch: 'full'}];
 @NgModule ({
     imports: [RouterModule.forRoot(patches)],
     exports: [RouterModule]
 
 })
export class AppRouter {}