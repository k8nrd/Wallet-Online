import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StartPageComponent } from './start-page.component';

const patches = [{path:'login', component: StartPageComponent}];
 @NgModule ({
     imports: [RouterModule.forRoot(patches)],
     exports: [RouterModule]
 
 })
export class LoginRouter {}