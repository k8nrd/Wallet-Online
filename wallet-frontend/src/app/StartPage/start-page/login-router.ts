import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StartPageComponent } from './start-page.component';
import { AuthGuard } from '../../auth-guard';

const patches = [{path:'login', component: StartPageComponent, canActivate: [AuthGuard]}];
 @NgModule ({
     imports: [RouterModule.forRoot(patches)],
     exports: [RouterModule]
 
 })
export class LoginRouter {}