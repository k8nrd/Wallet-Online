import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ChartsComponent } from './charts.component';
import { MainGuard } from '../../../main-guard';

const patches = [{path:'charts', component: ChartsComponent, canActivate: [MainGuard]}];
 @NgModule ({
     imports: [RouterModule.forRoot(patches)],
     exports: [RouterModule]
 
 })
export class ChartRouter {}