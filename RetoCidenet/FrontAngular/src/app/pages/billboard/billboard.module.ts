import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BillboardRoutingModule } from './billboard-routing.module';
import { BillboardComponent } from './billboard.component';
import { MovieIconComponent } from 'src/app/shares/movie-icon/movie-icon.component';
import {  MatCardModule } from '@angular/material/card';
import {MatGridListModule} from '@angular/material/grid-list';




@NgModule({
  declarations: [
    BillboardComponent,
    MovieIconComponent
    
  ],
  imports: [
    CommonModule,
    BillboardRoutingModule,
    MatCardModule,
    MatGridListModule

  ]
})
export class BillboardModule { }
