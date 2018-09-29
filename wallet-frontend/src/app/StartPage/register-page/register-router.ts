import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterPageComponent } from './register-page.component';
import { AuthGuard } from '../../auth-guard';

const patches = [{path:'register', component: RegisterPageComponent,  canActivate: [AuthGuard]}];
 @NgModule ({
     imports: [RouterModule.forRoot(patches)],
     exports: [RouterModule]
 
 })
export class RegisterRouter {}